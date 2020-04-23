package com.issc.util;

import com.issc.bean.FileParam;
import com.issc.bean.FormParam;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Map;

public class CollectionUtil {
    public static boolean isNotEmpty(List<?> list) {
        return list!=null&&!list.isEmpty();
    }

    public static boolean isEmpty(List<?> list) {
        return list==null&&list.isEmpty();
    }

    public static boolean isNotEmpty(Map<?,?> map) {
        return map!=null&&!map.isEmpty();
    }

    public static boolean isEmpty(Map<String, Object> map) {
        return map==null&&map.isEmpty();
    }
}
