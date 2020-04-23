package com.cxyup.core.service.user;

import com.cxyup.common.web.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * 保存用户名或验证码到Redis中
 * Session共享
 * @author lx
 *
 */
@Service("sessionProvider")
public class SessionProviderImpl implements SessionProvider{

    @Autowired
    private Jedis jedis;
    private Integer exp = 30;
    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Override
    public void setAttribuerForUsername(String name, String value) {
        // TODO Auto-generated method stub
        //保存用户名到Redis中
        //　K　：　CSESSIONID:Constants.USER_NAME   == name
        jedis.set(name + ":" +  Constants.USER_NAME, value);
        //时间
        jedis.expire(name + ":" +  Constants.USER_NAME, 60*exp);
    }

    @Override
    public String getAttributeForUsername(String name) {
        //fbb2016
        String value = jedis.get(name + ":" +  Constants.USER_NAME);
        if(null != value){
            //时间
            jedis.expire(name + ":" +  Constants.USER_NAME, 60*exp);
        }
        return value;
    }

}