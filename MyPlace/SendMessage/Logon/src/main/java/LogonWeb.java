import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * 登录指定网址
 */
public class LogonWeb {

    /**
     *连接指定URL,获取响应,实现登录功能
     * @param URL 登录路径
     * @param Referer 登录页面上一个页面
     * @param bodyMap 表单数据
     * @param User_Agent 用户标识
     * @return 返回响应
     * @throws IOException
     */
    public  Response okHttpConnect(String URL,String Referer, Map<String, String> bodyMap,String User_Agent) throws IOException {
       //新建客户端
        OkHttpClient client=new OkHttpClient();
        //新建请求表单
        FormBody.Builder formBody=new FormBody.Builder();
        //添加body请求数据,例如账号 密码 时间戳
        for (Map.Entry<String,String> entry: bodyMap.entrySet()) {
            formBody.add(entry.getKey(),entry.getValue());
        }
        FormBody body=formBody.build();
        //新建请求,并添加post方式内容
        Request request=new Request.Builder()
                .url(URL)
                .addHeader("Referer",Referer)
                .addHeader("User-Agent",User_Agent)
                .addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Origin","https://coyee.com")
                .post(body)
                .build();
        //客户端发出请求,返回响应
        return client.newCall(request).execute();
    }
}
