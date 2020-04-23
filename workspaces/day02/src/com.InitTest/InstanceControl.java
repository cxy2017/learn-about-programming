package com.InitTest;

class Bases{
    int count=10;
    public void display(){
        System.out.println(this.count);
    }
}
class Deriveds extends Bases{
    int count = 20;
    @Override
    public void display() {
        System.out.println(this.count);
    }
}
public class InstanceControl {
    public static void main(String[] args) {
        //父类
        Bases b=new Bases();
        System.out.println(b.count);
        b.display();
        System.out.println("______________________________________");
        //子类
        Deriveds d=new Deriveds();
        System.out.println(d.count);
        d.display();
        System.out.println("______________________________________");
        //多态
        Bases db=new Deriveds();
        System.out.println(db.count);
        db.display();
        System.out.println("______________________________________");
        //将Derived d赋给变量Bases d2b
        Bases d2b=d;
        System.out.println(d2b.count);
        d2b.display();
    }
}
