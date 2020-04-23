package com.issc.demo.service;

import java.util.List;
import java.util.Map;

import com.issc.annotation.Aspect;
import com.issc.annotation.Controller;
import com.issc.annotation.Service;
import com.issc.annotation.Transaction;
import com.issc.demo.model.Customer;
import com.issc.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供客户数据服务
 */
@Service
public class CustomerService {
    public static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    /**
     * 获取客户列表
     */
    @Transaction
    public List<Customer> getCustomerList(){

        String sql="SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }
    /**
     * 获取客户
     */
    public Customer getCustomer(Long id){
        String sql="SELECT * FROM customer WHERE id=?";
        return DatabaseHelper.queryEntity(Customer.class,sql,id);
    }
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> filedMap){
        return DatabaseHelper.insertEntity(Customer.class,filedMap);
    }
    /**
     * 更新客户
     */
    public boolean updateCustomer(long id,Map<String,Object> filedMap){
        return DatabaseHelper.updateEntity(Customer.class,id,filedMap);
    }
    /**
     * 删除客户
     */
    public boolean deleteCustomer(Long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
