import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
//comparator��ʵ�ʷ���������treeSet�������͵ĸ���,����
        TreeSet<String> ts1=new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return hashCode()>o2.hashCode()?1:hashCode()<o2.hashCode()?-1:0;
            }
        });
        ts1.add("nihao");
        ts1.add("xx");
        //comparator��ʵ�ʷ���������treeSet����������ͬ,����

        TreeSet<String> ts2=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()>o2.length()?1:o1.length()<o2.length()?-1:0;
            }
        });
        ts2.add("nihao");
        ts2.add("xx");
        System.out.println(ts1);
        System.out.println(ts2);

    }
}
