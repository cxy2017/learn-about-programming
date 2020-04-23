package practice;/*
import java.util.HashSet;
import java.util.Set;

class practice.Name{
    private String first;
    private String last;

    public practice.Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        practice.Name name = (practice.Name) o;

        if (!first.equals(name.first)) return false;
        return last.equals(name.last);
    }
}
public class practice.HashSetTest {
    public static void main(String[] args) {
        Set<practice.Name> set=new HashSet<practice.Name>();
        set.add(new practice.Name("hehe","xixi"));
        System.out.println( set.contains(new practice.Name("hehe","xixi")));

    }

}
*/
import java.util.HashSet;
import java.util.Set;

class Name{
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        if (!first.equals(name.first)) return false;
        return last.equals(name.last);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        return result;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        Set<Name> set=new HashSet<Name>();
        set.add(new Name("hehe","xixi"));
        System.out.println( set.contains(new Name("hehe","xixi")));

    }

}
