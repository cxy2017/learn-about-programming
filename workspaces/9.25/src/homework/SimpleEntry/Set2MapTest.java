package homework.SimpleEntry;

public class Set2MapTest {
    public static void main(String[] args) {
        Set2Map<String,Integer> scores=new Set2Map<String,Integer>();
        scores.put("语文",80);
        scores.put("数学",90);
        scores.put("英语",99);
        System.out.println(scores.size());
        scores.removeEntry("数学");
        System.out.println("删除键为\"数学\"的entry之后:"+scores);
        //根据key值提取出value
        System.out.println("根据语文获取得到:"+scores.get("语文"));
        //判断是否包含指定Key
        System.out.println("是否包含英语:"+scores.containsKey("英语"));
        //判断是否包含指定value
        System.out.println("是否包含99"+scores.containsValue(99));
        //清空集合
        scores.clear();
        System.out.println("执行clear之后的集合" +scores);
    }
}
