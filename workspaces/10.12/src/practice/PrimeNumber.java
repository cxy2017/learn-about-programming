package practice;

public class PrimeNumber {
    public static void main(String[] args) {
        int number = 10000000;//1ǧ��
//        ��ȡnumber��Χ�������ĸ���
//        int count= getPrime(number);//ѭ��������ȡ����
        int count = getPrimeSOE(number);//ɸ����
        System.out.println(count);//���Ϊ664579
    }

    private static int getPrimeSOE(int number) {
        int count = 0;
        if (number <= 1) return 0;
        int[] temp = new int[number + 1];
        for (int i = 2; i < number + 1; i++) {
            if (temp[i] == 0) {
                count++;
                int k = 2;
                while (k * i <= number) {
                    temp[k * i] = 1;
                    k++;
                }
            } else {
                continue;
            }
        }
        return count;
    }

    private static int getPrime(int number) {
        int count = 0;
        if (number == 0) return 0;
        if (number == 1) return 0;
        if (number == 2) return 0;
        for (int i = 2; i < number; i++) {
            boolean b = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
            }
        }
        return count;
    }
}
