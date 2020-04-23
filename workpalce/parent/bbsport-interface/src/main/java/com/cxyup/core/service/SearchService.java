package com.cxyup.core.service;

import cn.itcast.common.page.Pagination;

public interface SearchService {


    //全文检索
    //全文检索
    Pagination selectPaginationByQuery(Integer pageNo,String keyword,Long brandId,String price) throws Exception;
    //保存商品信息到solr服务器
    void insertProductToSolr(Long id);
}
