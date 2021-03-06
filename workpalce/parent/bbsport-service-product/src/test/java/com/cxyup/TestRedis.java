package com.cxyup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestRedis {

    @Autowired
    Jedis jedis;
    @Test
    public void testSpringJedis(){
        Long pno= jedis.incr("pno");
        System.out.println(pno);
    }
    @Test
    public void testRedis() throws Exception{
        Jedis jedis=new Jedis("192.168.200.128",6379);
        Long pno= jedis.incr("pno");
        System.out.println(pno);
    }
}
