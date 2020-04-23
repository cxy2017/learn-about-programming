package persiondemo;

import java.util.Scanner;

public class ScannerFormat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("���������");
        String address = scanner.next();
        System.out.println("�����빫˾����");
        String firmtype = scanner.next();
        System.out.println("�����빫˾����");
        String firmname = scanner.next();
        System.out.println("�������ϰ�����");
        String boosname = scanner.next();
        System.out.println("��������");
        String money = scanner.next();
        System.out.println("�������Ʒ");
        String production = scanner.next();
        System.out.println("�����뵥λ");
        String unit = scanner.next();
        System.out.println(address + "���" + firmtype + firmname + "�����ˣ����˵��ϰ�" + boosname + "�Ժ��ζģ�" +
                "Ƿ����" + money + "���ڣ���������С��������!����û�а취������" + production + "�ֹ���!" + "\r\n" + "ԭ�۶���һ" + unit + "��" +
                "����" + unit + "�ࡢ��" + unit + "���" + production + "��" +
                "����ȫ��ֻ����ʮ�飬ͳͳֻҪ��ʮ��!" + boosname + "���˵���" +
                "�㲻����!\r\n����������������˴���꣬�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ! ");
    }
}
