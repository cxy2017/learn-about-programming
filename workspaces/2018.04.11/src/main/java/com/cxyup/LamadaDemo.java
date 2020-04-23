package com.cxyup;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class LamadaDemo {
    public static void main(String[] args) {
//        runnableOperate();
//        evenHandler();
//        comparable();
//        foreach();
//            function();
//        createStream();
        covertStream();
    }

    /**
     * Stream collect操作
     */
    public static void covertStream() {
        String collect = Stream.of("You", "may", "assume").collect(Collectors.joining());
        System.out.println(collect);
    }

    /**
     * 通过其他api创建streamm
     */
    private static void createStream() {
        String demo = "AXDBGSFDAS";
        List<String> collect = Pattern.compile("[ABC]{1,3}").splitAsStream(demo).collect(Collectors.toList());
        System.out.println(collect);

        try {
            Stream<String> lines = Files.lines(Paths.get("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用lamda表达式和函数式接口predicate
     */
    public static void function(){
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        filter(list, (str) -> str.endsWith("a"));
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
    /**
     * 使用lamda表达式对列表进行迭代
     */
    public static void foreach(){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(a -> System.out.println(a));
        features.forEach(System.out::println);

    }

    /**
     * lamda定制Comparator
     */
    public static void comparable() {
        List<Integer> strings = Arrays.asList(1, 4, 3, 6, 5, 2);
        strings.sort((a, b) -> a > b ? -1 : 0);

//        Collections.sort(strings);
        System.out.println(strings);
    }
    /**
     * 用lamda表达式实现Runnable
     */
    public static void runnableOperate(){
        //java8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        }).start();
        //java8
        //用() -> {} 代码块替代了整个匿名类
        new Thread(() -> System.out.println("In java8,lamda expression rocks !!")).start();
    }
    /**
     * lamda表达式进行事件处理
     */
    private static void evenHandler() {
        JButton show = new JButton("show");
        show.addActionListener((e) ->{
            System.out.println("Lamda expressions Rocks");
            System.out.println("dsfsdf" + e.getActionCommand());
        });
    }

}
