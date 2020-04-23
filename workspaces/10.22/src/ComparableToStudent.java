import java.util.Comparator;

public class ComparableToStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getAge() - o2.getAge()) > 0 ? 1 : (o1.getAge() - o2.getAge()) < 0 ? -1 : 0;
    }
}
