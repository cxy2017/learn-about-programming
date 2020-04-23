package com.practice;

/**
 * ����ת��
 */
public class Conversion {
    public static void main(String[] args) {
        String two = "1010";
        String eight = "077";
        String sixteen = "AA";
//1        2ת8
        String two_to_eight = Integer.toOctalString(Integer.parseInt(two, 2));
        System.out.println("������:" + two + " �˽���:" + two_to_eight);
//2        2ת10
        String two_to_ten = Integer.toString(Integer.parseInt(two, 2));
        System.out.println("������:" + two + " ʮ����:" + two_to_ten);
//3        2ת16
        String two_to_sixteen = Integer.toHexString(Integer.parseInt(two, 2));
        System.out.println("������:" + two + " ʮ������:" + two_to_sixteen);
//4        8ת10
        String eight_to_ten = Integer.toString(Integer.parseInt(eight, 8));
        System.out.println("�˽���:" + eight + " ʮ����:" + eight_to_ten);
//5        8ת16
        String eight_to_sixteen = Integer.toHexString(Integer.parseInt(eight, 8));
        System.out.println("�˽���:" + eight + " ʮ������:" + eight_to_sixteen);
//6        10ת16
        String ten_to_sixteen = Integer.toHexString(100);
        System.out.println("ʮ����:" + 100 + " ʮ������:" + ten_to_sixteen);
//7        16ת8
        String sixteen_to_eight = Integer.toOctalString(Integer.parseInt(sixteen, 16));
        System.out.println("ʮ������:" + sixteen + " �˽���:" + sixteen_to_eight);
//8        10ת8
        String ten_to_eight = Integer.toOctalString(100);
        System.out.println("ʮ����:" + 100 + " �˽���:" + ten_to_eight);
//9        16ת2
        String sixteen_to_two = Integer.toBinaryString(Integer.parseInt(sixteen, 16));
        System.out.println("ʮ������:" + sixteen + " ������:" + sixteen_to_two);
//10        10ת2
        String ten_to_two = Integer.toBinaryString(100);
        System.out.println("ʮ����:" + 100 + " ������:" + ten_to_two);
//11        8ת2
        String eight_to_two = Integer.toBinaryString(Integer.parseInt(eight, 8));
        System.out.println("�˽���:" + eight + " ������:" + eight_to_two);
//12        16ת10
        String sixteen_to_ten = Integer.toString(Integer.parseInt(sixteen, 16));
        System.out.println("ʮ������:" + sixteen + " ʮ����:" + sixteen_to_ten);
    }
}
