package com.cxyup.core.service;

import com.cxyup.core.bean.TestTb;
import com.cxyup.core.dao.TestTbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试
 */
@Service("testTbService")
@Transactional//表示整个类都加了事务
public class TestTbServiceImpl implements TestTbService {
    @Autowired
    private TestTbDao testTbDao;

    public void insertTestTb(TestTb testTb){
        testTbDao.insertTestTb(testTb);
//        throw new RuntimeException();
    }
}
