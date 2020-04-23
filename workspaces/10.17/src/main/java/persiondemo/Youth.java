package persiondemo;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Youth extends Person {
    static int num=100;
    static {
        num+=100;
        System.out.println(num);
    }
    public static void main(String[] args) {
        double d=5/2;
        Baby baby=null;
        System.out.println(baby);
        baby.swalk();
        new Person().swalk();
    }

    public Youth() {
    }

    public Youth(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        System.out.println("變陛變變變");;
    }
}
