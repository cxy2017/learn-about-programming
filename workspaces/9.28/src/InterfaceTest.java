class MyUtil<E>{
    public static <Z> MyUtil<Z> nil(){
        return null;
    }
    public static <Z> MyUtil<Z> cons(Z head,MyUtil<Z> tail){
        return null;
    }
    E head(){
        return null;
    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        //这里无需指定方法中泛型类型,系统自动结合前面声明的泛型填充
        MyUtil<String> Is=MyUtil.nil();
        //等号后面调用方法时无需指定泛型类型
        MyUtil<String> Iss=MyUtil.<String>nil();
        //可调用cons方法所需的参数类型来推断类型参数为Integer
       MyUtil.cons(12,MyUtil.nil());
       //无需象下面这样在调用nil方法时指定类型参数的类型
        MyUtil.cons(14,MyUtil.<Integer>nil());
    }
}
