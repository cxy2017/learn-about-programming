package com.cxyup.core.dao.product;

import com.cxyup.core.bean.product.Brand;
import com.cxyup.core.bean.product.BrandQuery;

import java.util.List;

/**
 * 查询列表
 */
public interface BrandDao {
    //查询结果集、、名称 、是否可用、当前页，页数
    public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
    //查询总条数
    public Integer selectCount(BrandQuery brandQuery);
    //通过ID查询品牌
    public Brand selectBrandById(Long id);
    //修改
    public void updateBrandById(Brand brand);
    //批量删除
    public void deletes(Long[] ids);
}
