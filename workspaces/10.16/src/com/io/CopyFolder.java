package com.io;

import java.io.*;

/**
 * ����Ŀ¼
 *
 * @author cxy
 */
public class CopyFolder {
    public static void main(String[] args) throws IOException {
        String src = "D:" + File.separator + "Java";
        String target = "D:" + File.separator + "JavaCopy";
        copyDirectory(src, target);
    }

    private static void copyDirectory(String src, String target) throws IOException {
        File source = new File(src);
        File targets = new File(target);
        targets.mkdir();
        File[] files = source.listFiles();
        for (File file : files
                ) {
            if (file.isDirectory()) {
                String source1 = src + File.separator + file.getName();
                String target1 = target + File.separator + file.getName();
                copyDirectory(source1, target1);
            }
            if (file.isFile()) {
                File target2 = new File(target, file.getName());
                copyFile(file, target2);
            }
        }
    }

    private static void copyFile(File file, File target2) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file)
        );
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(target2)
        );
        byte[] buff = new byte[1024];
        int len = 0;
        if ((len = bis.read()) != -1) {
            bos.write(buff, 0, len);
        }
    }
}
