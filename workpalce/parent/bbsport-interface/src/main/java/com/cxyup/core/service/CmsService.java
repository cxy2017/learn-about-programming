package com.cxyup.core.service;

import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;

import java.util.List;

public interface CmsService {
    //查询商品信息
    Product selectProductById(Long productId);
    //查询sku结果集(包括颜色)
    List<Sku> selectSkuListByProductById(Long productId);
}
