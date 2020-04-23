package com.cxyup.service;

import com.cxyup.dao.LoginLogDao;
import com.cxyup.dao.UserDao;
import com.cxyup.domain.LoginLog;
import com.cxyup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//将UserService标注为一个服务层的Bean
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;
    //用于检查用户/密码的正确性
    public boolean hasMatchUser(String userName,String password){
        int marchCount=userDao.getMatchCount(userName,password);
        return marchCount>0;
    }
    //以用户名为条件加载User对象
    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user){
        LoginLog loginLog=new LoginLog();
        loginLog.setLoginLogId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }
}
