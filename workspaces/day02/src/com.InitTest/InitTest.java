package com.InitTest;

class Creature{
    {
        System.out.println("Creature的非静态代码块");
    }

    public Creature() {
        System.out.println("Creature的无参构造器");
    }
    public Creature(String name) {

        this();//调用本类的无参构造器
        System.out.println("Creature的带有name参数的构造器,name参数"+name);
    }
}
class Animal extends Creature{
    {
        System.out.println("Animal的非静态代码块");
    }

    public Animal(String name) {
        super(name);//调用父类带name参数的构造器
        System.out.println("Aniaml的带有一个参数的构造器,name参数"+name);
    }

    public Animal(String name,int age) {
        this(name);//使用this调用另一个带name参数重载的构造器
        System.out.println("Aniaml的带有一个参数的构造器,其age"+age);
    }
}
class Wolf extends Animal{
    {
        System.out.println("Wolf的非静态初始化块");
    }
    public Wolf() {
        super("灰太狼", 3);//调用父类带参构造器
        System.out.println("wolf的无参数的构造器");
    }
    public Wolf(double weight){
        this();//调用本类空参
        System.out.println("Wolf的带weight参数的构造器,weight参数"+weight);
        
    }
}
public class InitTest {
    public static void main(String[] args) {
        new Wolf(8.6);//调用Wolf类的weight参数构造器,一直调用到最顶点然后依次往下执行

        //先执行静态代码块后执行构造器语句
    }
}
