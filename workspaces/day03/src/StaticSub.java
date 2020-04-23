class StaticBase {
    //定义一个类变量
    static int count=20;
}
public class StaticSub extends StaticBase{
    static int count=200;
    public void info(){
        System.out.println("访问本类的count类变量:"+count);
        System.out.println("访问父类的count类变量:"+StaticBase.count);
        System.out.println("访问父类的count类变量:"+super.count);
    }
    public static void main(String[] args) {
        new StaticSub().info();
    }
}