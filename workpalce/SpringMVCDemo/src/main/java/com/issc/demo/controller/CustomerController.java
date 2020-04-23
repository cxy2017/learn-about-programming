package com.issc.demo.controller;

import com.issc.annotation.Autowired;
import com.issc.annotation.Controller;
import com.issc.annotation.RequestMapping;
import com.issc.bean.Data;
import com.issc.bean.Param;
import com.issc.bean.RequestMethod;
import com.issc.bean.View;
import com.issc.demo.model.Customer;
import com.issc.demo.service.CustomerService;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    /**
     * 进入客户管理界面
     */
    @RequestMapping(value = "/customer",requestMethod = RequestMethod.GET)
    public View index(){
        List<Customer> customerList=customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }

    /**
     *显示客户基本信息
     */
    @RequestMapping(value = "/customer_show",requestMethod = RequestMethod.GET)
    public View show(Param param){
        long id=param.getLong("id");
        Customer customer=customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer",customer);
    }
    /**
     * 进入创建客户界面
     */
    @RequestMapping(value = "/customer_create",requestMethod = RequestMethod.GET)
    public View create(Param param){
        return new View("customer_create.jsp");
    }
    /**
     * 处理创建客户请求
     */
    @RequestMapping(value = "/customer_create",requestMethod = RequestMethod.POST )
    public Data createSubmit(Param param){
        Map<String,Object> fieldMap=param.getFieldMap();
        boolean result=customerService.createCustomer(fieldMap);
        return new Data(result);
    }
    /**
     * 进入编辑客户界面
     */
    @RequestMapping(value = "/customer_edit",requestMethod = RequestMethod.GET )
    public View edit(Param param){
        long id=param.getLong("id");
        Customer customer=customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer",customer);
    }
    /**
     * 处理编辑客户请求
     */
    @RequestMapping(value = "/customer_edit",requestMethod = RequestMethod.POST )
    public Data editSubmit(Param param){
        long id=param.getLong("id");
        Map<String,Object> fieldMap=param.getFieldMap();
        boolean result=customerService.updateCustomer(id,fieldMap);
        return new Data(result);
    }
    /**
     * 处理删除客户请求
     */
    @RequestMapping(value = "/customer_edit",requestMethod = RequestMethod.DELETE )
    public Data delete(Param param){
        long id=param.getLong("id");
        boolean result=customerService.deleteCustomer(id);
        return new Data(result);
    }
}
