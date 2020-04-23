package com.cxyup.core.service.product;

import cn.itcast.common.page.Pagination;
import com.cxyup.core.bean.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cxyup.core.dao.product.BrandDao;
import com.cxyup.core.bean.product.BrandQuery;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 品牌管理
 * @author lx
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandDao brandDao;
    //查询分页对象
    public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo){
        BrandQuery brandQuery = new BrandQuery();
        //当前页
        brandQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        brandQuery.setPageSize(10);

        StringBuilder params = new StringBuilder();

        //条件
        if(null != name){
            brandQuery.setName(name);
            params.append("name=").append(name);
        }
        if(null != isDisplay){
            brandQuery.setIsDisplay(isDisplay);
            params.append("&isDisplay=").append(isDisplay);
        }else{
            brandQuery.setIsDisplay(1);
            params.append("&isDisplay=").append(1);
        }

        Pagination pagination = new Pagination(
                brandQuery.getPageNo(),
                brandQuery.getPageSize(),
                brandDao.selectCount(brandQuery)
        );
        //设置结果集
        pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
        //分页展示
        String url = "/brand/list.do";

        pagination.pageView(url, params.toString());

        return pagination;
    }
    @Override
    public Brand selectBrandById(Long id) {
        // TODO Auto-generated method stub
        return brandDao.selectBrandById(id);
    }
    @Autowired
    private Jedis jedis;
    @Override
    public void updateBrandById(Brand brand) {
        // TODO Auto-generated method stub
        //修改reids
        jedis.hset("brand",String.valueOf(brand.getId()),brand.getName());
        brandDao.updateBrandById(brand);
    }
    //从Redis中查询数据
    public List<Brand> selectBrandListFromRedis(){
        List<Brand> brands=new ArrayList<>();
        Map<String, String> hgetAll = jedis.hgetAll("brand");

        for (Map.Entry<String,String> entry:hgetAll.entrySet()){
            Brand brand=new Brand();
            brand.setId(Long.parseLong(entry.getKey()));
            brand.setName(entry.getValue());
            brands.add(brand);
        }
        return brands;
    }
    @Override
    public void deletes(Long[] ids) {
        // TODO Auto-generated method stub
        brandDao.deletes(ids);
    }
    @Override
    public List<Brand> selectBrandListByQuery(Integer isDisplay) {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay(isDisplay);
        // TODO Auto-generated method stub
        return brandDao.selectBrandListByQuery(brandQuery);
    }
}
