package homework.SimpleEntry;

public class Set2MapTest {
    public static void main(String[] args) {
        Set2Map<String,Integer> scores=new Set2Map<String,Integer>();
        scores.put("����",80);
        scores.put("��ѧ",90);
        scores.put("Ӣ��",99);
        System.out.println(scores.size());
        scores.removeEntry("��ѧ");
        System.out.println("ɾ����Ϊ\"��ѧ\"��entry֮��:"+scores);
        //����keyֵ��ȡ��value
        System.out.println("�������Ļ�ȡ�õ�:"+scores.get("����"));
        //�ж��Ƿ����ָ��Key
        System.out.println("�Ƿ����Ӣ��:"+scores.containsKey("Ӣ��"));
        //�ж��Ƿ����ָ��value
        System.out.println("�Ƿ����99"+scores.containsValue(99));
        //��ռ���
        scores.clear();
        System.out.println("ִ��clear֮��ļ���" +scores);
    }
}
