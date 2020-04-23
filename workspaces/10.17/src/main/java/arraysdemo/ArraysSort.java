package arraysdemo;
/**
 * 创建一个长度是8的字符串数组
 使用8个长度是5的随机字符串初始化这个数组
 对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
 */
public class ArraysSort {

    public static void main(String[] args) {
//        创建一个长度是8的字符串数组
//        使用8个长度是5的随机字符串初始化这个数组
        int arrayLength=8;
        int stringLength=10;
        String[] s=getRandomStringArray(arrayLength,stringLength);
//        打印数组
        toStringPrintln(s);
//        对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)

        new ArraysSort().sortStringArray(s,0,s.length-1);
//        打印数组
        toStringPrintln(s);
    }
    /**
     * 对字符串数组进行排序,并忽略字母大小写
     * 字符串只能是字母的任意组合
     * @param str 传入一个字符串数组
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
//       左指针
        int start=low;
//        右指针
        int end=high;
        String key=str[low];
        String temp;
        while (start<end) {
//        从右往左比较把小的放在key右边
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
     *前面字符串大于后面字符串返回1
     * 前面字符串小于后面字符串返回-1
     * 前面字符串等于后面字符串返回0
     * @param s 字符串1
     * @param key 字符串2
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
     * @param arrayLength 指定字符串数组长度
     * @param stringLength 指定字符串长度
     * @return 返回指定字符串长度和字符串数组长度的字符串数组
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
     * 打印字符串数组
     * @param str 传入需要打印的字符串数组
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