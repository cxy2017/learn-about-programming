package practice1;

/**
 * .�½�һ�������࣬����ȥ�ɷø��и�ҵ���˶�����ְҵ�Ŀ���
 * ���������֣����� practice1.Student��practice1.Teacher��practice1.Doctor��
 */
public class Repoter {
    public void interview(Person persion) {
        persion.view();
    }

    public static void main(String[] args) {
        Repoter repoter = new Repoter();
        Student student = new Student();
        Teacher teacher = new Teacher();
        Doctor doctor = new Doctor();
        repoter.interview(student);
        repoter.interview(teacher);
        repoter.interview(doctor);
    }
}
