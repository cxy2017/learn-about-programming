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
        //这里结果为true,原因是第一次创建test字符串后,字符串被缓存到字符串池中,第二次s2直接引用的
        //是字符串中的test所以si和s2指向的内存地址相同,相比较结果为true
        System.out.println(s1==s2);
        //这里结果为false,是因为s3引用的String对象是在内存中新开辟的空间存储的字符串,
        //test字符串所在的内存地址和s1\s2不同,所以相比价结果为false
        System.out.println(s1==s3);
        //这里值得注意的时如果在s4中计算时出出现了不确定的变量,那么就会导致比较结果为false
        //因为编译时无法确定字符串最终结果
        //如果计算式中变量有final修饰,有初始值,那么就可以实现宏变量,编译时能确定变量结果
        //那么比较结果为true
        //这里结果为true,是因为s4在编译时就直接计算出了结果,运行时直接引用的常量池中的test
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
