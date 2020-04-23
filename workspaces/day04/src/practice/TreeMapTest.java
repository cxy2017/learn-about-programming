package practice;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String,Double> tm=new TreeMap<String,Double>();
        tm.put("qqq",90.12);
        tm.put("www",92.12);
        tm.put("eee",93.12);
        tm.put("rrr",91.12);
        System.out.println(tm);
    }
}
