package com.cxyup;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 抓取网页上的图片指定网址
 *
 */
public class CatchImage {
//    发出请求获取响应
    public Response okHttpConnect(int ImagePage,int FolderPage,int year) throws IOException {
        String URL="http://img.mmjpg.com/"+year+"/"+FolderPage+"/";
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(URL+ImagePage+".jpg")
                .addHeader("Referer",
                        "http://www.mmjpg.com/mm/"+FolderPage+"/"+ImagePage)
                .build();
        return client.newCall(request).execute();
    }
//    获取图片地址并下载
    public boolean execute(int ImagePage,int FolderPage,int year) throws IOException {
        Response response= okHttpConnect(ImagePage,FolderPage,year);
//        获取网页body中所有数据生成字符串
        if (!response.isSuccessful()){
           return false;
        }
        byte[] image= response.body().bytes();
        downloadImage(image,ImagePage,FolderPage);
        return true;
    }
//        下载图片
    private void downloadImage(byte[] image, int imagePage, int folderPage) {
//        指定图片存储地址
        String PathName="d:\\imagesCategory"+File.separator+folderPage;
        File folder=new File(PathName);
        if (!folder.isDirectory()) folder.mkdir();
        File picture=new File(folder,imagePage+".jpg");
        try {
            FileOutputStream fis=new FileOutputStream(picture);
            fis.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
