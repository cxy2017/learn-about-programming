package com.cxyup.test;

import com.cxyup.model.Customer;
import com.cxyup.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }
    @Before
    public void init(){
        //TODO:初始化数据库
    }
    @Test
    public void getCustomerListTest (){
        List<Customer> customerList=customerService.getCustomerList(null);
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public void getCustomerTest(){
        long id=1;
        Customer customer=customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }
    @Test
    public void createCustomerTest(){
        Map<String,Object> filedMap=new HashMap<>();
        filedMap.put("name","customer100");
        filedMap.put("contact","john");
        filedMap.put("telephone","13512345678");
        boolean result=customerService.createCustomer(filedMap);
        Assert.assertTrue(result);
    }
    @Test
    public void updateCustomerTest(){
        long id=1;
        Map<String,Object> filedMap=new HashMap<>();
        filedMap.put("contact","Eric");
        boolean result=customerService.updateCustomer(filedMap);
        Assert.assertTrue(result);
    }
}
