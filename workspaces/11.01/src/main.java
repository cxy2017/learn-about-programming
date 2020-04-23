public class main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(10);
        list.add("Hello");
        list.add("World");
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(3));
    }
}
