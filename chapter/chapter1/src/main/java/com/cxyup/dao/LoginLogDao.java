package com.cxyup.dao;

import com.cxyup.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    //插入登录日志
    public void insertLoginLog(LoginLog loginLog){
        String sqlStr=" INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?) ";
        Object[] args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr,args);
    }
}
