package com.cxyup.controller;

import cn.itcast.common.page.Pagination;
import com.cxyup.core.bean.product.Brand;
import com.cxyup.core.bean.product.Color;
import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;
import com.cxyup.core.service.CmsService;
import com.cxyup.core.service.SearchService;

import com.cxyup.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * 前台商品
 * @author lx
 *
 */
@Controller
public class ProductController {

    //去首页  入口
    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }
    @Autowired
    private SearchService searchService;
    @Autowired
    private BrandService brandService;
    //搜索
    @RequestMapping(value = "/search")
    public String search(Integer pageNo,Long brandId,String price,String keyword,Model model) throws Exception{
        //品牌名称
        List<Brand> brands = brandService.selectBrandListFromRedis();
        model.addAttribute("brands",brands);
        model.addAttribute("brandId",brandId);
        model.addAttribute("price",price);

        //已选条件 容器
        Map<String,String > map=new HashMap<>();
        //品牌
        if (null!=brandId){
            for (Brand brand:brands){
                if (brandId==brand.getId()){
                    map.put("品牌",brand.getName());
                    break;
                }
            }
        }
        //价格
        if (null != price) {
            if (price.contains("-")){
                map.put("价格",price);
            }else {
                map.put("价格",price+"以上");
            }
        }
        model.addAttribute("map",map);
        Pagination pagination = searchService.selectPaginationByQuery(pageNo,keyword,brandId,price);
        model.addAttribute("pagination", pagination);
        model.addAttribute("keyword",keyword);
        return "search";
    }
    @Autowired
    private CmsService cmsService;
    //去商品详情页面\
    @RequestMapping("/product/detail")
    public String detail(Long id,Model model){
        //商品
        Product product = cmsService.selectProductById(id);
        //sku
        List<Sku> skus = cmsService.selectSkuListByProductById(id);
        Set<Color> colors=new HashSet<>();
        for (Sku sku:
             skus) {
            colors.add(sku.getColor());
        }
        model.addAttribute("skus",skus);
        model.addAttribute("product",product);
        model.addAttribute("colors",colors);
        return "product";
    }
}

