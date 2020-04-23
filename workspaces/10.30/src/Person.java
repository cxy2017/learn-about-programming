public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeOutOfBoundsException {
        if (age > 0 && age <= 100) {
            this.age = age;
        } else {
            throw new AgeOutOfBoundsException("年龄超出范围");
        }
    }

    public static void main(String[] args) {
        Person 小米 = new Person();
        try {
            小米.setAge(-1);
        } catch (AgeOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("年龄" + 小米.getAge());
    }
}
