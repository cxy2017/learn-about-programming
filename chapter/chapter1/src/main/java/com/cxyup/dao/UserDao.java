package com.cxyup.dao;
import com.cxyup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
//通过Spring注解定义一个DAO
@Repository
public class UserDao {
    //自动注入JdbcTemplate的Bean
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //根据用户名和密码来匹配用户数。等于1表示用户名和密码正确，等于0表示用户名或密码错误
    public int getMatchCount(String userName,String password){
        String sqlStr=" SELECT count(*) FROM t_user WHERE user_name=? and password=? ";
        //JdbcTemplate工具的queryForInt方法返回一个int值
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
    }
    //根据用户名获取User对象。
    public User findUserByUserName(final String userName){
        String sqlStr=" SELECT user_id,user_name FROM t_user WHERE user_name=? ";
        final User user =new User();

        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            //实现一个匿名内部类通过processRow方法将接收到的结果集中的参数存储到user对象中
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
            }
        });
        return user;
    }
    //更新用户积分、最后登录IP地址以及最后登录时间。
    public void updateLoginInfo(User user){
        String sqlStr=" UPDATE t_user SET last_visit=?,last_ip=? WHERE user_id=? ";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(),user.getUserId()});
    }
}
