package com.cxyup.core.service.product;


import cn.itcast.common.page.Pagination;
import com.cxyup.core.bean.product.Color;
import com.cxyup.core.bean.product.Product;

import java.util.List;

public interface ProductService {


    //分页对象
    Pagination selectPaginationByQuery(Integer pageNo,String name
            ,Long brandId,Boolean isShow);

    //颜色结果集
    List<Color> selectColorList();

    //商品保存
    void insertProduct(Product product);


    //上架
    void isShow(Long[] ids);

}
