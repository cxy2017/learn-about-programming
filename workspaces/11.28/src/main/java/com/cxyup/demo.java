package com.cxyup;

public class demo {
    public static void main(String[] args) {
        Countimpl countimpl = new Countimpl();
        CountProxy countProxy = new CountProxy(countimpl);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}
