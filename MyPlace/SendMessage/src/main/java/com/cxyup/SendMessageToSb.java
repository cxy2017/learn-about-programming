package com.cxyup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class SendMessageToSb {
//    指定定时时长
   static int timeInterval;
//    发出请求获取响应
    private Response okhttpConnect()throws IOException{
        OkHttpClient client=new OkHttpClient();
//        发出请求
        Request request=new Builder().url( "" +
                        "http://api.avatardata.cn/HistoryToday/LookUp?" +
                        "key=7f8bc79235a347f981afdd6e39501a2c" +
                        "&yue=10&ri=24&type=1&page=1&rows=21"
                ).build();
//        返回响应
        return client.newCall(request).execute();
    }
    //获取网页响应的body信息
    public void okHttpParseResponse()throws IOException{
        Response response=okhttpConnect();
        if (!response.isSuccessful()){
            throw new IOException("服务器端错误"+response);
        }
        ResponseBody responseBody=response.body();
        String message;
        message = responseBody.string();
        handleMessage(message);
    }
    //用json解析字符串信息
    private void handleMessage(String message) {
        JSONObject allData= JSON.parseObject(message);
        JSONArray results=allData.getJSONArray("result");
        for (int i=0 ;i<results.size();i++){
            JSONObject todayOfHistory=results.getJSONObject(i);
            System.out.println(
                    todayOfHistory.getIntValue("year")+"年"+todayOfHistory.getIntValue("month")
                    +"月"+todayOfHistory.getIntValue("day")+
                            "发生的事件:"+todayOfHistory.getString("title")
            );
//            定时器定时,参数为指定时间
            timeInterval=1000;
            timertask(timeInterval);
            }
        }

    private void timertask(int timeInterval) {
        try {
            Thread.sleep(timeInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


