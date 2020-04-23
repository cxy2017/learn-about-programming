package practice;

import java.util.HashMap;
import java.util.TreeMap;

public class MapValuesTest {
    public static void main(String[] args) {
        HashMap<String,String > scores=new HashMap<String,String >();
        scores.put("资质","19.01");
        scores.put("只是","21");
        scores.put("总是","32.01");
        scores.put("暂时","3.01");
        scores.put("早上","19.3");
        System.out.println(scores.values());
        System.out.println(scores.values().getClass());
    }
}
