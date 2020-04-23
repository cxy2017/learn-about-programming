package homework;


import java.util.*;
/**
 * 使用八种基本数据类型,进行类型转换,并使用不同方式为8种基本类型的变量赋值,熟悉每种数据赋值及表现形式
 */
public class CountDemo {
    ArrayList<String> a;
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("sss");
        list.add(new Object());
        list.add(null);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
