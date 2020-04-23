package practice2;

public class StudenSortDemo {
    public static void main(String[] args) {
        Student stu1 = new Student("闪烁", 21);
        Student stu2 = new Student("闪烁", 18);
        Student stu3 = new Student("闪烁", 19);
        Student stu4 = new Student("闪烁", 15);
        Student[] students = {stu1, stu2, stu3, stu4};
        QuikSort.sort(students, 0, students.length - 1);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
