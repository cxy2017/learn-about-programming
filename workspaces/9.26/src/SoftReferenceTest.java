import java.lang.ref.SoftReference;

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//�����ò���
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<Student>[] people=new SoftReference[100000];

        for(int i=0;i<people.length;i++){
            people[i]=new SoftReference<Student>(new Student("����"+i,(i+1)*4%100));
        }
        System.out.println(people[2].get());
        System.out.println(people[4].get());
        //֪ͨϵͳ����
        System.gc();
        System.runFinalization();
        System.out.println(people[2].get());
        System.out.println(people[4].get());
    }
}