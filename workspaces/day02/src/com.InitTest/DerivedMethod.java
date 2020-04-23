package com.InitTest;

class Animals {
    private String desc;
// 实例变量desc保存对象toString()方法的返回值
    public Animals() {
        //调用getDesc()方法初始化desc实例变量
        this.desc =getDesc();
    }

    public String getDesc() {
        return "Animal";
    }
    public String toString(){
        return desc;
    }
}
class Wolfs extends Animals{
    private double weight;
    private String name;

    public Wolfs( String name,double weight) {
        this.weight = weight;
        this.name = name;
    }
    //重写父类的getDesc()方法
    @Override
    public String getDesc() {
        return "Wolf[name="+name+",weight="+weight+"]";
    }
}
//调用被子类重写的父类方法
public class DerivedMethod {
    public static void main(String[] args) {
        System.out.println(new Wolfs("灰太狼",5.6).toString());
        //相当于调用了toString(),打印的是desc,Animals的空参构造器中调用的是Wolfs重写过的getDesc()方法,
        //其中Wolfs,实例变量已存在只是没有初始化,有系统默认值null和0.0
        //然后将getDesc返回的值赋给父类的deac实例变量,最后调用toString打印desc
    }
}
