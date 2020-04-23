package com.cxyup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.util.Random;
import java.util.zip.GZIPInputStream;

class AutoOrderForJD {
   private String user_agent="Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWeb" +
          "Kit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
   private String content_Type="text/plain;charset=utf-8";
   private String accept_encoding="gzip, deflate, br";
   private String accept_language="zh-CN,zh;q=0.8\\n";
   private String connection="keep-alive";
   private long timeStamp=System.currentTimeMillis();
   private int RandomNum;
   private String URL="https://qr.m.jd.com/show?appid=133&size=147&t=+"+timeStamp;
//    String referer="https://passport.jd.com/uc/popupLogin2013?clstag1=login|keycount|5|5&cl" +
//            "stag2=login|keycount|5|6&r=0.5320176917708792&t="+(timeStamp-1218)+"\\n";
    private String token;
    private OkHttpClient client;
    //获取响应
    public Response jDConnection() throws IOException {
        client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(URL)
                .addHeader("user-agent",user_agent)
                .addHeader("Content-Type",content_Type)
                .addHeader("accept-encoding",accept_encoding)
                .addHeader("accept-language",accept_language)
                .addHeader("Connection",connection)
                .get()
                .build();
        Response response=client.newCall(request).execute();
        return response;
    }
    //分析响应,获取二维码和set-cookie
    public boolean parseResponse() throws IOException, InterruptedException {
        Response response=jDConnection();
        if (!response.isSuccessful()){
            return false;
        }
        Headers headers=response.headers();
        String set_cookie1=headers.value(5);
        token=parseCookie2(headers.value(6));
        byte[] bytes=response.body().bytes();
        getCodeImage(bytes);
        return true;
    }
    //获取字符串中的token
    private String parseCookie2(String value) {
        int startIndex=value.indexOf("=");
        int endIndex=value.indexOf(";");
        return value.substring(startIndex+1,endIndex);
    }

    //获取登录二维码
    private void getCodeImage(byte[] bytes) throws IOException {
        File image=new File("d:\\imagesCategory","codeImage.PNG");
        FileOutputStream fis=new FileOutputStream(image);
        fis.write(bytes);
        fis.close();
        System.out.println("二维码获取成功");
    }
//    获取tickets
    public String getCookie() throws IOException, InterruptedException {
        Response response=codeImageScan();

        Headers headers= response.headers();
        byte[] jquery= response.body().bytes();
        ByteArrayInputStream byteArray=new ByteArrayInputStream(jquery);
        GZIPInputStream gzip=new GZIPInputStream(byteArray);
        byte[] temp=new byte[jquery.length];
        gzip.read(temp);
        gzip.close();
        System.out.println(new String(temp));
        return headers.get("coockie");
    }
//    扫描二维码状态返回响应
    private Response codeImageScan() throws IOException {
//        Accept:*/*
//Accept-Encoding:gzip, deflate, br
//Accept-Language:zh-CN,zh;q=0.8
//Connection:keep-alive
//Host:qr.m.jd.com
//Referer:https://passport.jd.com/uc/login?ltype=logout
//User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36
        Request request=new Request.Builder()
                .url("https://qr.m.jd.com/check?callback=jQuery"+getRandomNum()+
                        "&appid=133&token="+token +
                        "&_="+System.currentTimeMillis())
                .addHeader("Accept","*/*")
                .addHeader("Accept-Encoding","gzip, deflate, br")
                .addHeader("Accept-Language","zh-CN,zh;q=0.8")
                .addHeader("Connection","keep-alive")
                .addHeader("Host","qr.m.jd.com")
                .addHeader("Referer","https://passport.jd.com/uc/login?ltype=logout")
                .addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36")
                .get()
                .build();
        return client.newCall(request).execute();
    }

    private int getRandomNum() {
        while (RandomNum<100000) {
//            RandomNum = (int) Math.random() * 999999;
            RandomNum= new Random().nextInt(999999);
        }
        return RandomNum;
    }
}