package com.cxyup.core.service.user;

import com.cxyup.core.bean.order.Order;
import com.cxyup.core.bean.user.Buyer;

public interface BuyerService {
    //通过用户名查询用户对象
    Buyer selectBuyerByUsername(String username);
    //保存订单
    void insertOrder(Order order, String username);
}
