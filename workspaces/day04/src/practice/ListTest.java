package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Apple{
    double weight;

    public Apple(double weight) {
        this.weight = weight;
    }
}
//证明集合中存储的只是变量引用而不是对象本身
public class ListTest {
    public static void main(String[] args) {
        Apple a1=new Apple(2.2);
        Apple a2=new Apple(1.6);
        List<Apple> list = new ArrayList<Apple>(4);
        list.add(a1);
        list.add(a2);
        int i= a1.hashCode();
        System.out.println(i);
        System.out.println(list.get(0)==a1);
        System.out.println(list.get(1)==a2);
        HashMap<String,String> hashmap=new HashMap<String,String>();
        hashmap.put("你好","世界");

    }


}
