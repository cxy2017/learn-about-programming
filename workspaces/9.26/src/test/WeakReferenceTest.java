package test;

import java.lang.ref.WeakReference;

//�����ò���
public class WeakReferenceTest {
    public static void main(String[] args) {
        String string = new String("�ҵ�Idea");
        WeakReference<String> wr = new WeakReference<String>(string);
        string = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }
}
