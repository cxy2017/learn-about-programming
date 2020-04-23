package com.cxyup.core.service.product;

import com.cxyup.common.fdfs.FastDFSUtils;
import org.springframework.stereotype.Service;

@Service("uploadService")
public class UploadServiceImpl implements UploadService{


    //上传图片
    public String uploadPic(byte[] pic ,String name,long size){
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
