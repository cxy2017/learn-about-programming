package genericity;

public class Apple<T> {
    private T info;
    public Apple() {
    }
    public Apple(T info){
        this.info=info;
    }

    public T getT() {
        return info;
    }

    public void setT(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Apple<String> apple=new Apple<>("ÎÒµÄ·ºÐÍ");
        Apple<Integer> count=new Apple<>(12);
        System.out.println(apple.getT());
        System.out.println(count.getT());

        System.out.println(count.getClass().toString() );
    }
}