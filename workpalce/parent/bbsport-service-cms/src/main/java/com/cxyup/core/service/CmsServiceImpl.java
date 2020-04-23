package com.cxyup.core.service;

import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;
import com.cxyup.core.bean.product.SkuQuery;
import com.cxyup.core.dao.product.ColorDao;
import com.cxyup.core.dao.product.ProductDao;
import com.cxyup.core.dao.product.SkuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//评价晒单广告静态化
@Service("cmsService")
public class CmsServiceImpl implements CmsService{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private ColorDao colorDao;
    //查询商品信息
    public Product selectProductById(Long productId){
        return productDao.selectByPrimaryKey(productId);
    }
    //查询sku结果集(包括颜色)查询有货的
    public List<Sku> selectSkuListByProductById(Long productId){
        SkuQuery skuQuery = new SkuQuery();
        skuQuery.createCriteria().andProductIdEqualTo(productId).andStockGreaterThan(0);
        List<Sku> skus = skuDao.selectByExample(skuQuery);
        for (Sku sku:
             skus) {
            sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
        }
        return skus;
    }
}
