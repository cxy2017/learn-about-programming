package com.cxyup;


import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.ProductQuery;
import com.cxyup.core.dao.product.ProductDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestProduct {
    @Autowired
    private ProductDao productDao;
    @Test
    public void testAdd()throws Exception{
      /*  Product product=productDao.selectByPrimaryKey(1L);
        System.out.println(product);*/
        /**
         * 条件、分页、指定字段查询 排序
         */

        ProductQuery example= new ProductQuery();
//        example.createCriteria().andBrandIdEqualTo(4L).andNameLike("好莱坞");
        //分页
        example.setPageNo(2);
        example.setPageSize(10);
        example.setOrderByClause("id desc");
        example.setFields("id,brand_id");
        List<Product> products =productDao.selectByExample(example);
        for (Product product:products){
            System.out.println(product.toString());
            }

    }
}
