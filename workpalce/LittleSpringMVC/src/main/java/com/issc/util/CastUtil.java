package com.issc.util;


import org.apache.commons.lang3.StringUtils;

public class CastUtil {
    public static long castLong(Object o) {
        return CastUtil.castLong(o,0);
    }

    private static long castLong(Object obj, long defaultValue) {
        long longValue=defaultValue;
        if (obj!=null){
            String strValue=castString(obj);
            if (StringUtil.isNotEmpty(strValue)){
                longValue=Long.parseLong(strValue);
            }
        }
        return longValue;
    }

    public static String castString(Object obj) {
        return CastUtil.castString(obj,"");
    }

    private static String castString(Object obj, String defualtValue) {
        return obj!=null?String.valueOf(obj):defualtValue;
    }
    public static double castDouble(Object o){
        return castDouble(o,0);
    }
    public static double castDouble(Object o,double defaultValue) {
        double doubleValue=defaultValue;
        if (o!=null){
            String strValue=castString(o);
            if (StringUtil.isNotEmpty(strValue)){
                doubleValue=Double.parseDouble(strValue);
            }
        }
        return doubleValue;
    }
    public static int castInt(Object o){
        return castInt(o,0);
    }
    public static int castInt(Object o,int defaultValue) {
        int intValue=defaultValue;
        if (o!=null){
            String strValue=castString(o);
            if (StringUtil.isNotEmpty(strValue)){
                intValue=Integer.parseInt(strValue);
            }
        }
        return intValue;
    }
    public static boolean castBoolean(Object o){
        return castBoolean(o,false);
    }
    public static boolean castBoolean(Object o,boolean defaultValue) {
        boolean booleanValue=defaultValue;
        if (o!=null){
            String strValue=castString(o);
            if (StringUtil.isNotEmpty(strValue)){
                booleanValue=Boolean.parseBoolean(strValue);
            }
        }
        return booleanValue;
    }
}
