package practice1;

public class Practice {
    public static void main(String[] args) {
       /* int r=0;
        for (int i=0;i<5;i++){
            for (int j=5-i;j>0;j--){
                r+=i*j;
            }
        }
        System.out.println(r);*/
        String str = "adc";
        changeString(str);
        System.out.println(str);
    }

    static void changeString(String str) {
        str = "cdf";
    }
}
