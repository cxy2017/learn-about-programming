package practice;

/*. 假设有一个方法 public int method()， 会返回一个整数
        在这个方法中有try catch 和 finally.
        try 里返回 1
        catch 里 返回 2
        finally 里 返回3
        那么，这个方法到底返回多少？(写出测试代码)*/
public class TryCatchReturnDemo {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        int i = 0;
        try {
            System.out.println("进入try");
            throw new Exception();
//            return ++i;
        } catch (Exception e) {
            System.out.println("进入catch");//
            return ++i;
        } finally {
            System.out.println("进入finally");//
            ++i;
//            return ++i;
            // return 3;
        }
    }
}
