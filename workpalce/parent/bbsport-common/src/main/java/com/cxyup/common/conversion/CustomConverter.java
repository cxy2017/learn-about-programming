package com.cxyup.common.conversion;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器
 * 去掉前后空格
 * <S,T>:S 页面上类型  T:转换后类型
 */
public class CustomConverter implements Converter<String,String>{

    @Override
    public String convert(String s) {
        try{
            if (null!=s){
                s=s.trim();
                if (!"".equals(s)){
                    return s;
                }
            }
        }catch (Exception e){
        }
            return null;
    }
}
