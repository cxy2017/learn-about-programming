package com.cxyup.core.service.staticpage;

import java.util.Map;

public interface StaticPageService {
    //静态化 商品
    void productStaticPage(Map<String,Object> root, String id);
}
