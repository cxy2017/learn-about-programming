package persiondemo;

public class log {
    public static void main(String[] args) {
        double n = 619968792.99999999;//double n=619968793.001;
        double count = 1 + 1 / n;
        for (double i = 1; i < n; i++) {
            count *= (1 + 1 / n);
        }
        System.out.println(count);//2.7182818248280713 ��2.7182818292126174ֻ�����޽ӽ�Eֵ
        System.out.println(Math.E);//2.718281828459045
    }
}
