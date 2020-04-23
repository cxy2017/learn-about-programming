package com.cxyup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        streamFileter();
        createStream();
    }

    /**
     * 创建stream的方式
     */
    public static void createStream() {
//        1.从array或list创建stream
//        Stream<Integer> integerStream = Stream.of(10, 20, 30, 40);
//        String[] cityArr={"beijing","shanghai","chengdu"};
//        Stream<String> cityArr1 = Stream.of(cityArr);
        List<String> langList = Arrays.asList("Java", "Python", "Swift", "HTML");
        Stream<String> mapStream = langList.stream().map(String::toUpperCase);

        System.out.println(Arrays.asList(mapStream.toArray()));
    }

    /**
     * 通过流进行过滤操作
     */
    public static void streamFileter() {
        List<String> stringList = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");
        int countByIterator = 0;
        for (String string : stringList) {
            if (string.length() > 7) {
                countByIterator++;
            }
        }
        System.out.println("countByIterator: " + countByIterator);
        long countByStream = stringList.parallelStream().filter(w -> w.length() > 7).count();
        System.out.println("countByStream: " + countByStream);
    }
}
