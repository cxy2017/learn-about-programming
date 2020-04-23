package com.issc.helper;

import com.issc.bean.FormParam;
import com.issc.bean.Param;
import com.issc.util.CodecUtil;
import com.issc.util.StreamUtil;
import com.issc.util.StringUtil;
import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * 请求助手类
 */
public final class RequestHelper {
    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request)throws IOException{
        List<FormParam> formParamList=new ArrayList<>();
        formParamList.addAll(parseParameterNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }

    private static List<FormParam> parseParameterNames(HttpServletRequest request) {
        List<FormParam> formParamList=new ArrayList<>();
        Enumeration<String> paramNames=request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String fieldName=paramNames.nextElement();
            String[] fieldValues=request.getParameterValues(fieldName);
            if (ArrayUtils.isNotEmpty(fieldValues)){
                Object fieldValue;
                if (fieldValues.length==1){
                    fieldValue=fieldValues[0];
                }else {
                    StringBuilder stringBuilder=new StringBuilder("");
                    for (int i=0;i<fieldValues.length;i++){
                        stringBuilder.append(fieldValues[i]);
                        if (i!=fieldValues.length-1){
                            stringBuilder.append(StringUtil.SEPARATOR);
                        }
                    }
                    fieldValue=stringBuilder.toString();
                }
                formParamList.add(new FormParam(fieldName,fieldValue));
            }
        }
        return formParamList;
    }
    private static List<FormParam> parseInputStream(HttpServletRequest request)throws IOException {
       List<FormParam> formParamList=new ArrayList<>();
       String body= CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
       if (StringUtil.isNotEmpty(body)){
           String[] kvs=StringUtil.splitString(body,"&");
           if (ArrayUtils.isNotEmpty(kvs)){
               for(String kv:kvs){
                   String[] array= StringUtil.splitString(kv,"=");
                   if (ArrayUtils.isNotEmpty(array)&&array.length==2){
                       String fieldName=array[0];
                       String fieldValue=array[1];
                       formParamList.add(new FormParam(fieldName,fieldValue));
                   }
               }
           }
       }
       return formParamList;
    }


}
