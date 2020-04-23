package homework;

/**
 * JavaDoc
 * <br>定义学生、老师、教室三个类,为三个类编写文档注释
 * <br>并使用Javadoc工具来生成API文档
 * @author cxy
 * @version 1.0
 */
public class JavaDoc {

}

/**
 * 学生类
 */
class Student{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    /**
     * Student构造器
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取姓名
     * @return 姓名
     */

    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     * @return 年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *学生在上课
     */
    public void attendClass(){
        System.out.println("学生"+name+"上课");
    }
}

/**
 * 教师类
 */
class Teacher{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    /**
     * Teacher构造器
     * @param name
     * @param age
     */
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取姓名
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     * @return 年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *老师在上课
     */
    public void teach(){
        System.out.println("学生"+name+"上课");
    }
}

/**
 * 教室类
 */
class Classroom{
    /**
     * 教室编号
     */
    private int ID;

    public Classroom(int ID) {
        this.ID = ID;
    }

    /**
     * 获取教室ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * 设置教室ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 教室在使用中
     */
    public void using(){
        System.out.println(ID+ "教室在使用中");
    }
}