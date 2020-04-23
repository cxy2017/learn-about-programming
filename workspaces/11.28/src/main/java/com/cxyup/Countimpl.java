package com.cxyup;

public class Countimpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查询账户");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户");
    }
}
