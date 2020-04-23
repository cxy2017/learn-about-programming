package persiondemo;

public class Person {
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
       this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("人类走路");
    }
    public static void swalk(){
        System.out.println("人类走路");
    }


}
