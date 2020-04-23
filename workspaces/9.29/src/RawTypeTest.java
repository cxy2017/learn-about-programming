import java.util.ArrayList;
import java.util.List;

public class RawTypeTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("myjava");
        list.add("head");
        list.add("brain");
        List<Integer> lists=new ArrayList<>();
        lists=list;
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));//这里不报错是因为这里调用了toString
            //Integer in = lists.get(i);
            //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
           // System.out.println(in);
        }
    }
}
