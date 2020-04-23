
public class FloatTest {
    public static void main(String[] args) {

        final float f = 999999999;
        //要注意float上限,这里赋值超过了上限,所以直接显示最大值
        System.out.println(f);
        System.out.println(f + 1);
        System.out.println(f == f + 1);
        System.out.println(Float.MAX_VALUE);
    }

}
