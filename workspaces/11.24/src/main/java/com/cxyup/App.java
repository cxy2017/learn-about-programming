package com.cxyup;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {/*      也可以使用：
        person one=(Person)Class.forName("reflction.Person").newInstance();
        生成类的实例*/

        Person one = new Person();
        //得到对象的类信息
        Class<?> classes = one.getClass();

        //获取Person类的所有方法
        Method m[] = classes.getDeclaredMethods();
        System.out.println("reflection.Person的方法：");
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i].toString());
        }
        System.out.println("<==================>");


        //获取Person类的所有方法
        Field f[] = classes.getDeclaredFields();
        System.out.println("reflection.Person的属性：");
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].toString());
        }
        System.out.println("<==================>");

        //获取Person类的构造函数
        Constructor<?> c[] = classes.getConstructors();
        System.out.println("reflection.Person的构造函数：");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i].toString());
        }
        System.out.println("<==================>");

        //获取Person类的接口
        Class<?> in[] = classes.getInterfaces();
        System.out.println("reflection.Person的接口：");
        for (int i = 0; i < c.length; i++) {
            System.out.println(in[i].toString());
        }
        System.out.println("<==================>");
    }
    /**
     * reflection.Person的方法：
     public void com.cxyup.Person.sleep()
     private void com.cxyup.Person.grow()
     public void com.cxyup.Person.eat()
     <==================>
     reflection.Person的属性：
     private java.lang.String com.cxyup.Person.name
     private java.lang.String com.cxyup.Person.sex
     private int com.cxyup.Person.age
     <==================>
     reflection.Person的构造函数：
     public com.cxyup.Person()
     <==================>
     reflection.Person的接口：
     Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
     at com.cxyup.App.main(App.java:50)
     */
}
