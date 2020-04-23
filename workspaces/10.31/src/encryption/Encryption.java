package encryption;

import java.io.*;

/*
对一个文本文件进行加密，要求：
        数字：
        如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
        如果是9的数字，变成0
        字母字符：
        如果是非z字符，向右移动一个，比如d变成e, G变成H
        如果是z，z->a, Z-A。
        字符需要保留大小写
        非字母字符
        比如',&^ 保留不变，中文也保留不变
*/
public class Encryption {
    public static void main(String[] args) throws IOException {
        //加密前存储位置
        File file = new File("D:\\Java", "EncryptionFile.txt");
        //加密后存储位置
        File fileEn = new File("D:\\Java", "EncryptionFileEn.txt");
        //进行文件加密
        encryptionFile(file, fileEn);
    }

    /**
     * 进行文件加密
     *
     * @param file   加密前存储位置
     * @param fileEn 加密后存储位置
     * @throws IOException IO异常
     */
    private static void encryptionFile(File file, File fileEn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEn)));
        String temp1;
        //读取一行加密并写入新文件
        while ((temp1 = br.readLine()) != null) {
            //字符串加密
            String temp2 = encryptionString(temp1);
            bw.write(temp2);
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    private static String encryptionString(String temp) {
        char[] chars = temp.toCharArray();
        //标记是否在前面的判断题中已添加
        boolean flag;
        StringBuilder stringBuilder = new StringBuilder();
        for (int tempChar : chars) {
            flag = true;
            if ((tempChar >= (int) '0' && tempChar < (int) '9') || (tempChar >= (int) 'A' && tempChar < (int) 'Z')
                    || (tempChar >= (int) 'a' && tempChar < (int) 'z')) {
                stringBuilder.append((char) (++tempChar));
                flag = false;
            }
            if (tempChar == (int) '9') {
                stringBuilder.append('0');
                flag = false;
            }
            if (tempChar == (int) 'Z') {
                stringBuilder.append('A');
                flag = false;
            }
            if (tempChar == (int) 'z') {
                stringBuilder.append('a');
                flag = false;
            }
            if (flag) {
                stringBuilder.append((char) tempChar);
            }
        }
        return stringBuilder.toString();
    }
}
