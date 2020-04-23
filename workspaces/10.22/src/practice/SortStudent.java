package practice;

import java.util.Arrays;

public class SortStudent {
    public static void main(String[] args) {
        Student stu1 = new Student("小马", 32);
        Student stu2 = new Student("顶点", 23);
        Student stu3 = new Student("等等", 54);
        Student stu4 = new Student("㏒", 43);
        Student[] students = {stu1, stu2, stu3, stu4};
        Arrays.sort(students, new ComparableToStudent());
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
