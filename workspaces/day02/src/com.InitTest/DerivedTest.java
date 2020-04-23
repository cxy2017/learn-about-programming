package com.InitTest;
class Base{
    private int i=2;

    public Base() {
        this.display();//输出0,调用的Derived的实例方法,调用该方法时Derived实例中i变量没有被赋值,为系统默认值0
        System.out.println(this.i);//输出2,调用的是Base的实例变量
    }
    public void display(){
        System.out.println(i);
    }
}
class Derived extends Base{
    private int i=22;
    public Derived(){
        i=222;
    }
    public void display(){
        System.out.println(i);
    }
}
//访问子类对象的实例变量
public class DerivedTest {
    public static void main(String[] args) {
        new Derived();//调用Derived类的空参构造器
    }
}
