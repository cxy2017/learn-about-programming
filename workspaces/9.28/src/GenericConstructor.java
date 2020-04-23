public class GenericConstructor {
    public static void main(String[] args) {
        new <String>Foo("111");
        new <Integer>Foo(12);
        new <Double>Foo(2.1);
        new <Character>Foo('Œ“');
    }
}
class Foo{
    public <T>Foo(T t){
        System.out.println(t);
    }
}