import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
class Name {
    private String first;
    private String last;
    public Name(String f,String l){
        first = f;
        last = l;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o.getClass() == Name.class){
            Name n =(Name)o;
            return Objects.equals(first,n.first)
                && Objects.equals(last,n.last);
        }
        return false;
    }
}

public class  HashMapTest{
    public static void main(String[] args){
        Name name1 = new Name("first1","last1");
        Set<Name> set = new HashSet<>();
        set.add(name1);
        Name name2 = new Name("first1","last1");
        System.out.println("contains name1:"+set.contains(name1));
        System.out.println("contains name2:"+set.contains(name2));
    }
}