package com.cxyup.core.service.product;

import com.cxyup.core.bean.BuyerCart;
import com.cxyup.core.bean.BuyerItem;
import com.cxyup.core.bean.product.Color;
import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;
import com.cxyup.core.bean.product.SkuQuery;
import com.cxyup.core.dao.product.ColorDao;
import com.cxyup.core.dao.product.ProductDao;
import com.cxyup.core.dao.product.SkuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 库存管理
 *
 * @author lx
 *
 */
@Service("skuService")
@Transactional
public class SkuServiceImpl implements SkuService {


    @Autowired
    private SkuDao skuDao;
    @Autowired
    private ColorDao colorDao;

    //商品ID 查询 库存结果集
    public List<Sku> selectSkuListByProductId(Long productId) {
        SkuQuery skuQuery = new SkuQuery();
        skuQuery.createCriteria().andProductIdEqualTo(productId);
        List<Sku> skus = skuDao.selectByExample(skuQuery);
        //15
        for (Sku sku : skus) {
            // 3条Sql  一级缓存
            sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
        }
        return skus;
    }

    //修改
    public void updateSkuById(Sku sku) {
        skuDao.updateByPrimaryKeySelective(sku);
    }

    @Autowired
    ProductDao productDao;

    //通过SKUID查询SKU对象
    public Sku selectSkuById(long id) {
        //Sku对象
        Sku sku = skuDao.selectByPrimaryKey(id);
        //商品对象
        sku.setProduct(productDao.selectByPrimaryKey(sku.getProductId()));
        //颜色对象
        sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
        return sku;
    }

    @Autowired
    private Jedis jedis;

    //保存商品到Redis中
    public void insertBuyerCartToRedis(BuyerCart buyerCart, String username) {
        //判断购物项的长度大于0
        List<BuyerItem> items = buyerCart.getItems();
        if (items.size() > 0) {
            for (BuyerItem buyerItem : items) {
                //键
                String key="buyerCart:" + username;
                //skuid
                long skuId=buyerItem.getSku().getId();
                //新增商品数
                Integer amount = buyerItem.getAmount();
                //如果商品已存在就增加对应的商品数量，反之则新建商品并添加数量
                if (jedis.hexists(key,String.valueOf(skuId))){
                    jedis.hincrBy(key,String.valueOf(skuId),amount);
                }else {
                    jedis.hset(key,
                            String.valueOf(skuId)
                            , String.valueOf(amount));
                }
            }
        }
    }

    //取出购物车从Redis
    public BuyerCart selectBuyerCartFromRedis(String username) {
        BuyerCart buyerCart = new BuyerCart();
        Map<String, String> hgetAll = jedis.hgetAll("buyerCart:" + username);
        if (null != hgetAll) {
            Set<Map.Entry<String, String>> entrySet = hgetAll.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
//				5：追加当前商品到购物车
                Sku sku = new Sku();
                //ID
                sku.setId(Long.parseLong(entry.getKey()));
                BuyerItem buyerItem = new BuyerItem();
                buyerItem.setSku(sku);
                //Amount
                buyerItem.setAmount(Integer.parseInt(entry.getValue()));
                //追加商品到购物车
                buyerCart.addItem(buyerItem);

            }
        }
        return buyerCart;
    }
}
