package com.cxyup;

import com.cxyup.core.bean.TestTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cxyup.core.service.TestTbService;

import java.util.Date;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestTbTest {
    @Autowired
    private TestTbService testTbService;
    @Test
    public void testAdd()throws Exception{
        TestTb testTb=new TestTb();
        testTb.setName("小玲玲2");
        testTb.setBirthday(new Date());
        testTbService.insertTestTb(testTb);
    }
}
