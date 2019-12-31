# Map

> HashSet判断两个对象相等的标准除了要求通过equals()方法比较返回true之外，还要求两个对象的hashCode()返回值相等。准确的说是先比较hahsCode，再比较equals。如果hashCode返回值不一样，直接返回false了。
```java
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
```

> Result
```java
contains name1:true
contains name2:false
```