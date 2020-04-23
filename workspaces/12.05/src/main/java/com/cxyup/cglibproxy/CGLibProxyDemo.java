package com.cxyup.cglibproxy;

import com.cxyup.Person;

public class CGLibProxyDemo {
    public static void main(String[] args) {
        //创建一个CGLibProxy动态代理实例
        //通过指定类对象可以获取到指定的动态代理实例
//        CGLibProxy cgLibProxy=new CGLibProxy();
//        Person person= cgLibProxy.getProxyInstance(Person.class);
//        person.behavior();
//        让cgLibProxy类自动继承了Person类
//        Person person1= (Person) Enhancer.create(Person.class,cgLibProxy);
//        person1.behavior();

        Person person2 = CGLibProxy.getInstance().getProxyInstance(Person.class);
        person2.behavior();
    }
}
