package persiondemo;

public class OldMen extends Person {
    public OldMen() {
    }

    public OldMen(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        System.out.println("Öô×Å¹ÕÕÈ×ß");
    }
}
