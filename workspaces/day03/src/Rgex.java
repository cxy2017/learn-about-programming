public class Rgex {
    public static void main(String[] args) {
        String string="hi,i am fine hello famouse";
        System.out.println(string.replaceAll("\\bf\\w*e\\b","0"));
    }
}
