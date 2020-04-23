package com.cxyup.core.service.product;

import cn.itcast.common.page.Pagination;
import com.cxyup.core.bean.product.Brand;

import java.util.List;

public interface BrandService {

    //查询分页对象
    Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo);

    //查询结果集
    List<Brand> selectBrandListByQuery(Integer isDisplay);
    //通过ID查询品牌
    Brand selectBrandById(Long id);

    //修改
    void updateBrandById(Brand brand);
    //删除
    void deletes(Long[] ids);// List<Long> ids;
    //从Redis中查询数据
    List<Brand> selectBrandListFromRedis();
}
