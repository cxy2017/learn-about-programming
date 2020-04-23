package com.cxyup.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {
    //加载配置文件
   public static Properties  loadProps(String fileName){
       Properties properties=new Properties();
       InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
       try {
           properties.load(is);
       } catch (IOException e) {
          throw new RuntimeException("加载配置文件失败",e);
       }
       return properties;
   }
   //获取配置
   public static String getString(Properties properties,String pathName,String defaultPathName){
       if (pathName!=null&&pathName!=""){
           return properties.getProperty(pathName);
       }
       return properties.getProperty(defaultPathName);
   }
   public static String getString(Properties properties,String pathName){
       return getString(properties,pathName,"");
   }
}
