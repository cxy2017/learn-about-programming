package arraysdemo;
/**
 * ����һ��������8���ַ�������
 ʹ��8��������5������ַ�����ʼ���������
 ���������������򣬰���ÿ���ַ���������ĸ����(���Ӵ�Сд)
 */
public class ArraysSort {

    public static void main(String[] args) {
//        ����һ��������8���ַ�������
//        ʹ��8��������5������ַ�����ʼ���������
        int arrayLength=8;
        int stringLength=10;
        String[] s=getRandomStringArray(arrayLength,stringLength);
//        ��ӡ����
        toStringPrintln(s);
//        ���������������򣬰���ÿ���ַ���������ĸ����(���Ӵ�Сд)

        new ArraysSort().sortStringArray(s,0,s.length-1);
//        ��ӡ����
        toStringPrintln(s);
    }
    /**
     * ���ַ��������������,��������ĸ��Сд
     * �ַ���ֻ������ĸ���������
     * @param str ����һ���ַ�������
     */
   /* private static void sortStringArray(String[] str) {
        String temp;
        for (int i = 0; i < str.length-1; i++) {
            for (int j = i+1; j <str.length ; j++) {
                char[] charsI=str[i].toCharArray();
                char[] charsJ=str[j].toCharArray();
                    for (int k=0;k<charsI.length;k++){
                            if (charsI[k]>=97)
                                charsI[k]-=32;
                            if (charsJ[k]>=97)
                                charsJ[k]-=32  ;
                            if (charsI[k]>charsJ[k]){
                            temp=str[i];
                            str[i]=str[j];
                            str[j]=temp;
                            break;
                        }
                        if (charsI[k]<charsJ[k])
                            break;
                    }
            }
         }
    }*/
    private void sortStringArray(String[] str,int low,int high) {
//       ��ָ��
        int start=low;
//        ��ָ��
        int end=high;
        String key=str[low];
        String temp;
        while (start<end) {
//        ��������Ƚϰ�С�ķ���key�ұ�
            while (start < end && (compareTo(str[end], key) == 1)) {
                end--;
            }
            if (compareTo(str[end], key) == -1) {
                temp = str[end];
                str[end] = key;
                key = temp;
            }

            while (start < end && (compareTo(str[start], key) == -1)) {
                start++;
            }
            if (compareTo(str[start], key) == 1) {
                temp = str[start];
                str[start] = key;
                key = temp;
            }
        }
        if (start>low) sortStringArray(str,low,start-1);
        if (end<high) sortStringArray(str,end+1,high);
    }
    /**
     *ǰ���ַ������ں����ַ�������1
     * ǰ���ַ���С�ں����ַ�������-1
     * ǰ���ַ������ں����ַ�������0
     * @param s �ַ���1
     * @param key �ַ���2
     * @return 1,0,-1
     */
    private int compareTo(String s, String key) {
        char[] charS=s.toCharArray();
        char[] charKey=key.toCharArray();
        for (int i=0;i<s.length();i++){
            if(charS[i]>='a')
                charS[i]=(char) (charS[i]-32);
            if(charKey[i]>='a')
                charKey[i]=(char) (charKey[i]-32);
            if (charS[i]>charKey[i])
                return 1;
            if (charS[i]<charKey[i])
                return -1;
        }
        return 0;
    }
    /**
     *
     * @param arrayLength ָ���ַ������鳤��
     * @param stringLength ָ���ַ�������
     * @return ����ָ���ַ������Ⱥ��ַ������鳤�ȵ��ַ�������
     */
    private static String[] getRandomStringArray(int arrayLength,int stringLength) {
        String[] arrays=new String[arrayLength];
        StringBuilder temp =new StringBuilder();
        for (int i=0;i<arrayLength;i++){
            for (;temp.length()<stringLength;){
                int c=65+(int)(58*Math.random());
                if(c<91||c>96)
                    temp.append((char) c);
            }
            arrays[i]=temp.toString();
            temp.delete(0,temp.length());
        }
        return arrays;
    }
    /**
     * ��ӡ�ַ�������
     * @param str ������Ҫ��ӡ���ַ�������
     */
    private static void toStringPrintln(String[] str) {
        System.out.print("[");
        for (int i = 0; i < str.length; i++) {
            if (i==str.length-1){
                System.out.println(str[i]+"]");
                break;
            }
            System.out.print(str[i]+",");
        }
    }
}