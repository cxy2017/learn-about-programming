package persiondemo;

public class Baby extends Person {
    public Baby(String name,int age){
        super(name,age);
    }
    public Baby(){}

    @Override
    public void walk() {
        System.out.println("婴儿爬着走");
    }
    public int walk(int i) {
        System.out.println("婴儿爬着走");
        return 0;
    }
}
