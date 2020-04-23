package com.cxyup.core.service.user;

import com.cxyup.core.bean.BuyerCart;
import com.cxyup.core.bean.BuyerItem;
import com.cxyup.core.bean.order.Detail;
import com.cxyup.core.bean.order.Order;
import com.cxyup.core.bean.product.Color;
import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;
import com.cxyup.core.bean.user.Buyer;
import com.cxyup.core.bean.user.BuyerQuery;
import com.cxyup.core.dao.order.DetailDao;
import com.cxyup.core.dao.order.OrderDao;
import com.cxyup.core.dao.product.ColorDao;
import com.cxyup.core.dao.product.ProductDao;
import com.cxyup.core.dao.product.SkuDao;
import com.cxyup.core.dao.user.BuyerDao;
import com.cxyup.core.service.product.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private BuyerDao buyerDao;

    //通过用户名查询用户对象
    public Buyer selectBuyerByUsername(String username){
        BuyerQuery buyerQuery = new BuyerQuery();
        buyerQuery.createCriteria().andUsernameEqualTo(username);

        List<Buyer> buyers = buyerDao.selectByExample(buyerQuery);
        if(null != buyers && buyers.size() > 0){
            return buyers.get(0);
        }
        return null;
    }
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DetailDao detailDao;

    @Autowired
    private Jedis jedis;
    //保存订单
    public void insertOrder(Order order,String username){
        //id（订单编号）全国唯一Redis
        Long id = jedis.incr("oid");
        order.setId(id);
        //加载购物车
        BuyerCart buyerCart = selectBuyerCartFromRedis(username);
//		把购物车装满
            List<BuyerItem> items = buyerCart.getItems();
            for (BuyerItem buyerItem : items) {
                buyerItem.setSku(selectSkuById(buyerItem.getSku().getId()));
            }
        //运费
        order.setDeliverFee(buyerCart.getFee());
        //总价
        order.setTotalPrice(buyerCart.getTotalPrice());
        //订单金额
        order.setOrderPrice(buyerCart.getProductPrice());
        //支付状态
        if (order.getPaymentWay()==1){
            order.setIsPaiy(0);
        }else {
            order.setIsPaiy(1);
        }
        //订单状态：0：提交订单  1：仓库配货 2：商品出库 3：等待收货 4：完成 5：待退货 6：已退货
        order.setOrderState(0);
        //时间 后台程序自己写的
        order.setCreateDate(new Date());
        //用户id ：前台用户做注册（用户名、密码）用户id 由Redis生成 用户id :用户名 保存到redis中
        String uid = jedis.get(username);
        order.setBuyerId(Long.parseLong(uid));
        //保存订单
        orderDao.insertSelective(order);
        //保存订单详情
        for (BuyerItem buyerItem:items){
            Detail detail=new Detail();
            Sku sku = buyerItem.getSku();
            Product product = sku.getProduct();
            Color color = sku.getColor();
            //id
        //订单id
            detail.setOrderId(id);
        //商品编号
            detail.setProductId(sku.getProductId());
        //商品名称
            detail.setProductName(product.getName());
        //颜色
            detail.setColor(color.getName());
        //尺码
            detail.setSize(sku.getSize());
        //价格
            detail.setPrice(sku.getPrice());
        //数量
            detail.setAmount(buyerItem.getAmount());
        //购物车提供
            detailDao.insertSelective(detail);
        }
        //清空购物车
        jedis.del("buyerCart:fbb2016");
        //练习hash 指定key

    }
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ColorDao colorDao;
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