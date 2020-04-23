package practice;

import java.util.Arrays;

//内部类中的局部变量
interface IntArrayProductor{
    //借口里面定义product方法,封装处理行为
   public int product();
}
public class CommandTest {
    //定义一个方法,生成指定长度的数组,数组元素由cmd负责生成
    public int[] prosses(IntArrayProductor cmd,int length){
        int[] array=new int[length];
        for (int i=0;i<length;i++){
            array[i]=cmd.product();
        }
        return array;
    }
    public static void main(String[] args) {
        final int  seed=5;//内部类中要访问局部变量,必须在局部变量前加final
        CommandTest cd=new CommandTest();
        int[] arr=cd.prosses(new IntArrayProductor(){
          public  int product(){
                return (int)Math.round(Math.random()*seed);
            }
        },6);
        System.out.println(Arrays.toString(arr));
    }
}
