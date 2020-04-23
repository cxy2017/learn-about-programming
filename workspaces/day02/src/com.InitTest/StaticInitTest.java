package com.InitTest;
/*
测试类变量初始化
 */
public class StaticInitTest {
    //声明一个Int型类变量
  static int count;
    //声明一个静态代码块
    static{
        System.out.println("StaticInitTest静态代码块");
        names="java编程兵书";
    }
    public static String names="程序设计";

    public static void main(String[] args) {
        System.out.println(names);
        System.out.println(StaticInitTest.names);
        System.out.println(new StaticInitTest().names);

    }
}
