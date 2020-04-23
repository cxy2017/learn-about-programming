package com.cxyup;

/**
 * 代理类（增强Countimpl）
 */
public class CountProxy implements Count {
    private Countimpl countimpl;

    public CountProxy(Countimpl countimpl) {
        this.countimpl = countimpl;
    }

    @Override
    public void queryCount() {
        System.out.println("查询之前");
        countimpl.queryCount();
        System.out.println("查询之后");
    }

    @Override
    public void updateCount() {
        System.out.println("修改之前");
        countimpl.updateCount();
        System.out.println("修改之后");
    }
}
