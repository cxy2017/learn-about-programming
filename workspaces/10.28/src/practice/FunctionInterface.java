package practice;

/**
 * 测试函数式接口
 */
@FunctionalInterface
public interface FunctionInterface {
    static void foo() {
        System.out.println("foo类方法");
    }

    static void bar() {
        System.out.println("bar默认的方法");
    }

    void test();//只定义一个抽象方法
}
