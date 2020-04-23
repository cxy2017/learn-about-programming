public class StringTest {
    private final char value[];
    public StringTest(){
        this.value = new StringTest().value;
    }
    public static void main(String[] args) {
        String s1="test";
        String s2="test";
        String s3=new String("test");
        String s4="te"+"st";
        //������Ϊtrue,ԭ���ǵ�һ�δ���test�ַ�����,�ַ��������浽�ַ�������,�ڶ���s2ֱ�����õ�
        //���ַ����е�test����si��s2ָ����ڴ��ַ��ͬ,��ȽϽ��Ϊtrue
        System.out.println(s1==s2);
        //������Ϊfalse,����Ϊs3���õ�String���������ڴ����¿��ٵĿռ�洢���ַ���,
        //test�ַ������ڵ��ڴ��ַ��s1\s2��ͬ,������ȼ۽��Ϊfalse
        System.out.println(s1==s3);
        //����ֵ��ע���ʱ�����s4�м���ʱ�������˲�ȷ���ı���,��ô�ͻᵼ�±ȽϽ��Ϊfalse
        //��Ϊ����ʱ�޷�ȷ���ַ������ս��
        //�������ʽ�б�����final����,�г�ʼֵ,��ô�Ϳ���ʵ�ֺ����,����ʱ��ȷ���������
        //��ô�ȽϽ��Ϊtrue
        //������Ϊtrue,����Ϊs4�ڱ���ʱ��ֱ�Ӽ�����˽��,����ʱֱ�����õĳ������е�test
        System.out.println(s1==s4);

    }
    public int compareTo(StringTest anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
}
