package practice;

import java.io.*;

/**
 * 移除java文件中的注释
 */
public class RemoveAnnotation {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("D:\\arrayDemo.java");
        File fileOut = new File("D:\\ArrayDemo.java");
        fileOut.createNewFile();
        removeAnnotation(fileIn, fileOut);
    }

    private static void removeAnnotation(File fileIn, File fileOut) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        String str;
        int index;
        while ((str = br.readLine()) != null) {
//            当当前行'//'不存在时就复制当前行
            if ((str.indexOf("//")) == -1) {
                bw.write(str, 0, str.length());
                bw.newLine();
            }
//            当当前行'//'不在开头时就仅复制//号前面部分
            if ((index = str.lastIndexOf("//")) > 0) {
//                if (str.matches("[^\"]*/{2}.*")){
                bw.write(str, 0, index);
                bw.newLine();
//                }
            }
            bw.flush();
        }
        br.close();
        bw.close();

    }
}
