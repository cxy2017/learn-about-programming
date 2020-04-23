package homework.SimpleEntry;
import java.util.*;
class MyClass{
int value;
public MyClass(){}
public MyClass(int value){
this.value = value;
}
 public String toString(){
 return value+"";
}
}
public class TestList{
public static void main(String args[]){
/*        int[] array={23,1,34,5,21,89};
        Arrays.sort(array);

                AbstractMap
    for (int i = 0; i <array.length ; i++) {
        System.out.println(array[i]);
    }
    MyClass mc1 = new MyClass(10);
MyClass mc2 = new MyClass(20);
MyClass mc3 = new MyClass(30);
List list = new ArrayList();
list.add(mc1);
list.add(mc2);
list.add(mc3);
MyClass mc4 = (MyClass) list.get(1);
//MyClass mc4=(MyClass)mc2;
mc4.value = 50;
for(int i = 0; i<list.size(); i++){
System.out.println(list.get(i));*/
//    System.out.println(TestList.highestOneBit(4));
}
    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }
}
