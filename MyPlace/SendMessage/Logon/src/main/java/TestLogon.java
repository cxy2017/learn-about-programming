import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录测试
 */
public class TestLogon {
    public static void main(String[] args) throws IOException {
        //创建一个Map用于存储body键值对
        Map<String,String> bodyMap=new HashMap<>();
        //账号
        bodyMap.put("uid","15520761781");
//        密码
        bodyMap.put("pwd","chen101920");
        //时间戳
        long timeStamp=System.currentTimeMillis();
        bodyMap.put("timestamp",timeStamp+"");
        //登录页面URL
        String URL="https://coyee.com/action/user/signin";
        //URL的上一个页面,用于防盗链
        String Referer="https://coyee.com/signin";
        //用户标识
        String User_Agent="Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
//        发出请求,获取响应
        Response response=new LogonWeb().okHttpConnect(URL,Referer,bodyMap,User_Agent);
//        获取响应头集合,打印查看
        Headers headers= response.headers();
        for (int i=0;i<headers.size();i++){
            System.out.println(headers.name(i)+":"+headers.value(i));
        }
//        打印响应body信息
        System.out.println(response.body().string());
    }
}
