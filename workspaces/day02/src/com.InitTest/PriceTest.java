package com.InitTest;
/*
类变量的初始化过程:
 定义一个pricel类,有InitPrice类变量指定初始值作为每次打折的初始值
 */
class Price {
    final static Price INSTANCE=new Price(2.8);
    static int initPrice=20;
    double currntcount;
    public Price(double discount) {
         currntcount=initPrice-discount;
    }
}
public class PriceTest{
    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currntcount);
        //-2.8 因为在类加载时先类变量开辟空间并int类型初始化系统默认赋值为0.
        // 然后语句直接调用类的第一句调用构造函数,所以为currntcount赋值,
        // 跳过了中间为类变量InitPrice赋值,所以结果为0-2.8= -2.8

        Price p=new Price(2.8);
        System.out.println(p.currntcount);
        //17.2 类加载完成后(类只加载一次),创建实例对象,先对类变量初始化,然后执行构造器中的语句
    }


}