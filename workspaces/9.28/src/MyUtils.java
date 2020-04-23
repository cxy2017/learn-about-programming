import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
复制一个集合并返回1最后一个复制的值
 */
public class MyUtils {
    public static  <T> T copy(Collection<? super T> dest,Collection<T> src){
        T last=null;
        for(T t:src){
            last=t;
            dest.add(t);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> numbers=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        integers.add(new Integer(1));
        Integer in=copy(numbers,integers);
        System.out.println(in);
    }
}
