package com.issc.util;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;

/**
 * 获取Config.properties配置
 */
public class PropsUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(PropsUtil.class);
    //获取配置properties

    /**
     * 首先创建一个配置对象，然后通过当前线程类加载器获取到指定文件的字节输入流
     * 运用try with resource 技术优雅的处理代码异常
     * 将字节流加载到配置对象中，从而完成配置文件的读取
     * @param fileName 文件名
     * @return 配置对象
     */
    public static Properties loadProps(String fileName){
        Properties properties=new Properties();
        try (InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("properties load failure",e);
            throw new RuntimeException(e);
        }
        return properties;
    }
    //获取配置文件中的字符串值
    public static String getString(Properties properties,String pathName,String defaultPathName){
        if (pathName==null||"".equals(pathName)){
            return properties.getProperty(defaultPathName);
        }else {
            return properties.getProperty(pathName);
        }
    }
    //优化输入参数
    public static String getString(Properties properties,String pathName){
        return getString(properties,pathName,"");
    }
//    获取配置文件中的int值
    public static int getInt(Properties properties, String pathName, String defaultPathName) {
        if (pathName==null||"".equals(pathName)){
            return Integer.valueOf(properties.getProperty(defaultPathName));
        }else {
            return Integer.valueOf(properties.getProperty(pathName));
        }
    }
    public static int getInt(Properties properties,String pathName){
        return getInt(properties,pathName,"");
    }
}
