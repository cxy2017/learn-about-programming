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
        //��������ָ�������з�������,ϵͳ�Զ����ǰ�������ķ������
        MyUtil<String> Is=MyUtil.nil();
        //�Ⱥź�����÷���ʱ����ָ����������
        MyUtil<String> Iss=MyUtil.<String>nil();
        //�ɵ���cons��������Ĳ����������ƶ����Ͳ���ΪInteger
       MyUtil.cons(12,MyUtil.nil());
       //���������������ڵ���nil����ʱָ�����Ͳ���������
        MyUtil.cons(14,MyUtil.<Integer>nil());
    }
}
