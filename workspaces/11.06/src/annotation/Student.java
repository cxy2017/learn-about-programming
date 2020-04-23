package annotation;

import java.io.File;
import java.lang.reflect.Field;

public class Student {
    @StudentHandler(name = "xiaoming", age = 1)
    public static String name;
    public static int age;

    public static void main(String[] args) {
        Class student = Student.class;
        Field[] fields = student.getFields();
        for (Field field :
                fields) {
            StudentHandler an = field.getAnnotation(StudentHandler.class);
            if (an != null) {
                age = an.age();
                name = an.name();
            }
        }
        System.out.println("name:" + name + File.separator + "age:" + age);
        ;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
