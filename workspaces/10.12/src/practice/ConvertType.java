package practice;

/*1.�Ѹ����� 3.14 ת��Ϊ �ַ��� "3.14"
        �ٰ��ַ��� ��3.14�� ת��Ϊ ������ 3.14
        ����ַ����� 3.1a4��ת��Ϊ��������õ�ʲô��*/
public class ConvertType {
    public static void main(String[] args) {
        double d1 = 3.14;
        System.out.println(d1);
        String str1 = Double.toString(d1);
        System.out.println(str1);

        double d = new Double(str1);
        System.out.println(d);
        String str2 = "3.1a4";
        System.out.println(str2);
        double d2 = new Double(str2);
        //�����������ָ�ʽ�쳣Exception in thread "main" java.lang.NumberFormatException: For input string: "3.1a4"
        System.out.println(d2);
    }
}
