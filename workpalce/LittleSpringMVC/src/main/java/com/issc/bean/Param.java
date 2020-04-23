package com.issc.bean;

import com.issc.util.CastUtil;
import com.issc.util.CollectionUtil;
import com.issc.util.StringUtil;
import net.sf.cglib.core.CollectionUtils;
import org.apache.commons.fileupload.FileItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数对象(分为表单参数与文件参数)
 */
public class Param {
//    private Map<String,Object> paramMap;
    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;
    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }
    /**
     * 获取请求参数映射
     */
    public Map<String,Object> getFieldMap(){
        Map<String,Object> fieldMap=new HashMap<>();
        if (CollectionUtil.isNotEmpty(formParamList)){
            for (FormParam formParam :
                    formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue=formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)){
                    fieldValue=fieldMap.get(fieldName)+ StringUtil.SEPARATOR+fieldValue;
                }
                fieldMap.put(fieldName,fieldValue);
            }
        }
        return fieldMap;
    }
    /**
     * 获取上传文件映射
     */
    public Map<String,List<FileParam>> getFileMap(){
        Map<String,List<FileParam>> fileMap=new HashMap<>();
        if (CollectionUtil.isNotEmpty(fileParamList)){
            for (FileParam fileParam:fileParamList){
                //通过文件参数获取到字段名
                String fieldName=fileParam.getFieldName();

                List<FileParam> fileParamList;
                if (fileMap.containsKey(fieldName)){
                    fileParamList =fileMap.get(fieldName);
                }else {
                    fileParamList=new ArrayList<>();
                }
                fileParamList.add(fileParam);
                fileMap.put(fieldName,fileParamList);
            }
        }
        return fileMap;
    }
    /**
     * 获取所有上传文件
     */
    public List<FileParam> getFileList(String fieldName){
        return getFileMap().get(fieldName);
    }
    /**
     * 获取唯一上传文件
     */
    public FileParam getFile(String fieldName){
        List<FileParam> fileParamList=getFileList(fieldName);
        if (CollectionUtil.isNotEmpty(fileParamList)&&fileParamList.size()==1){
            return fileParamList.get(0);
        }
        return null;
    }
    /**
     * 验证参数是否为空
     */
    public boolean isEmpty(){
        return CollectionUtil.isEmpty(formParamList)&&CollectionUtil.isEmpty(fileParamList);
    }
    /**
     * 根据参数名获取String型参数值
     */
    public String getString(String name){
        return CastUtil.castString(getFieldMap().get(name));
    }
    /**
     * 根据参数名获取double型参数
     */
    public double getDouble(String name){
        return CastUtil.castDouble(getFieldMap().get(name));
    }
    /**
     * 根据参数名获取long型参数
     */
    public long getLong(String name){
        return CastUtil.castLong(getFieldMap().get(name));
    }

    /**
     * 根据参数名获取int型参数
     */
    public int getInt(String name){
        return CastUtil.castInt(getFieldMap().get(name));
    }
    /**
     * 根据参数名获取Boolean型参数
     */
    public boolean getBoolean(String name){
        return CastUtil.castBoolean(getFieldMap().get(name));
    }
    /**
     * 获取所有字段信息
     */
   /* public Map<String, Object> getParamMap() {
        return paramMap;
    }*/
   /* public FileItem getFile(String name){
        Object paramValue=paramMap.get(name);
        if (paramValue!=null&&paramValue instanceof List){
            return (FileItem) ((List)paramValue).get(0);
        }else {
            return null;
            //throw new RuntimeException("there is no file")
        }
    }*/
}
