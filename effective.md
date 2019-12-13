# Effective Java

## 9. 覆盖equals时总要覆盖hashCode

### HashMap#get

`
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
    
final Node<K,V> getNode(int hash, Object key) {
     Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
     if ((tab = table) != null && (n = tab.length) > 0 &&
         (first = tab[(n - 1) & hash]) != null) {
         if (first.hash == hash && // always check first node
             ((k = first.key) == key || (key != null && key.equals(k))))
             return first;
         if ((e = first.next) != null) {
             if (first instanceof TreeNode)
                 return ((TreeNode<K,V>)first).getTreeNode(hash, key);
             do {
                 if (e.hash == hash &&
                     ((k = e.key) == key || (key != null && key.equals(k))))
                     return e;
             } while ((e = e.next) != null);
         }
     }
     return null;
 }
`


## 考虑实现compareTo

无论何时实现具有合理排序的值类，你都应该让该类实现`Comparable`接口，以便在基于比较的集合中轻松对其实例进行排序、搜索和使用。使用`compare`或者`Comparator`接口中的构建方法。

违反 `compareTo` 约定的类可能会破坏依赖于比较的其它类。依赖于比较的类，包括排序后的集合`TreeSet` 和`TreeMap`,以及包含搜索和排序算法的实用程序类
`Collections`和`Arrays`。

Java8 Comparator接口提供了一系列比较器方法，可以全比较器流畅地构建。这些比较器可以实现`compareTo`方法，就像`Comparable`接口所要求的那样。

`
private static final Comparator<PhoneNumber> COMPARATOR = 
        comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn){
    return COMPARATOR.compare(this,pn);
}
`

`compareTo`和`compare` 方法依赖于两个值之间的差值。但它可能导致整数最大长度溢出和IEEE 754 浮点数运算失真的危险。使用静态`compare`方法可以避免该问题。

`
static Comparator<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1,Object o2) {
        return Integer.compare(o1.hashCode(),o2.hashCode());
    }
}
//or
static Comparator<Object> hashCodeOrder = Comparator.comparingInt(o -> o.hashCode());
`

## 15. 使类和成员的可访问性最小化

一个设计良好的组件隐藏了它的所有实现细节，干净地将它的API与实现分离开来。然后，组件只通过它们的API进行通信。并对彼此的内部工作一无所知。这也被称为信息的隐藏或封装。
组件可以独立开发，测试，优化，使用，理解和修改。（加速了系统的开发）
减轻了维护的负担，因为可以更快速地理解组件，调试或更换组件，而不用担心损害其它组件。
可以有效地进行性能调整，一旦系统完成并且分析确定哪些组件导致了性能问题，则可以优化组件，而不会影响别人的正解组件。
降低构建大型系统风险，即使系统不能运行，各个独立的组件也是可能可用的。

**如果你把它公开，你就有义务永远地支持它，以保持兼容性**
如果一个方法重写一个超类方法，那么它在子类中的访问级别就不能低于父类的访问级别。（这对于确保子类实例在父类实现可用的地方是可用的是必要的）。特例：如果一个类实现了接口，那么接口中的所有类方法都必须在该类中声明为public。

非零长度的数组总是可变的，所有类具有公共静态final数组属性，或返回这样一个属性的访问器是错误的。

`
//Potential security hole
public static final Thing[] VALUES={...};
`
解决方法1 ：

`
private static final Thing[] PRIVATE_VALUES={...};
public static final List<Thing> VALUES=
    Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
`

方法2：

`
private static final Thing[] PRIVATE_VALUES={....};
public static final Thing[] values(){
    return PRIVATE_VALUES.clone();
}
`

## 16. 在公共类中使用访问方法而不是公共属性

公共类不应该暴露可变属性。公共类暴露不可变属性的危害仍然存在问题，但其危害较小。然而，有时需要包级私有或者私有内部类来暴露属性，无论此类是否是可变的。

## 17 最小化可变性

不可变类比可变类更容易设计，实现和使用。它们不太容易出错，更安全。

使一个类不可变，可遵循以下五条规则：
1. 不提供修改对象状态的方法（也称为mutators）。
2. 确保这个类不能被继承
3. 把所有属性设置为final
4. 把所有属性设置为private
5. 确保对任何可变组件的互斥访问

*不可变对象本质上是线程安全;它们不需要同步。*
*不仅可以共享不可变对象，而且可以共享内部信息*
*不可变对象为其他对象提供了很好的构件*
*不可变对象提供了免费的原子失败机制*
*不可变对象的主要缺点是对于第个不同的值都需要一个单独的对象*

如果你的不可变类实现`Serializable`接口,并且它包含一个或者多个引用可变对象的属性，则必须提供显示的`readObject` `readResolve` `ObjectOutputStream.writeUnshared` 和 `ObjectInputStream.readUnshared`方法，即默认的序列化形式也是可以接受的。

## 18.组合优于继承

只有在两个类之间存在“is-a”关系的情况下，B类才能继承A类。如果试图让B类继承A类，问自己这个问题：*每个B都是A吗？如果你不能回答这个问题，那么B就不应该继承A。*

在决定使用继承代替组合之前，你就忘问自己最后一组问题。*对于试图继承的类，它的API有没有缺陷呢？如果有，你是否愿意将这些缺陷传播到你的类的API中？继承传播父类API中的任何缺陷，而组合可以让你设计一个隐藏这些缺陷的新的API*

## 19. 要么设计继承并提供文档说明，要么禁用继承

> 构造方法绝对不能直接或者间接调用可重用的方法

`
public class class Super{
    //
    public Super(){
        overrideMe();
    }
    public void overrideMe();
}
`

`
public final class Sub extends Super{
    private final Instant instant;
    Sub(){
        instant = Instant.now();
    }
    
    // 
    @Override
    public void overrideMe(){
        System.out.println(instant);
    }

    public static void main(String[] args){
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
`
你可能期望这个程序打印再次instance实例，但是它第一次打印出null，因为在Sub构造方法有机会初始化instance属性之前，overrideMe被Super构造方法调用。这个程序观察两个不同状态的final属性！
Super的构造方法调用了overrideMe方法，如果子类重写了overrideMe方法。因为在Sub构造方法有机会初始化instant属性之前，overrideMe被Super构造方法调用。

1. 设计一个继承需要很大的努力，并且对这个类有很大的限制。
2. 在没有想要安全地子类化的设计文档和说明的类中禁止子类化。（两种方式禁止子类化）
    - 1.声明类为final
    - 2.使所有的构造方法都是私有或者包级私有，并且添加公共静态工厂来代替构造方法。

## 20. 接口优于抽象类

> Java 有两种机制来定义允许多个实现的类型：接口和抽象类。由于Java 8 引入了接口默认方法，因此这两种机制都允许为某些方法提供实现。

**注意：接口的默认方法不允许重写诸如`equals`,`hashCode`,`toString`等 `Object`方法**
Java允许单一继承。只能继承一个类，但是能实现多个接口。

`Comparable` `Iterable` `Autocloseable` 

## 21. 为后代设计接口

编写一个默认方法并不总是可能的，它保留了每个可能实现的所有不变量
在默认方法的情况下，接口的现有实现类可以在没有错误或警告的情况下编译，但在运行时会失败。
虽然在接口被发布后可能会修正一些存在缺陷，但不要太指望这一点。

## 22. 接口仅用来定义类型

** 常量接口模式是对接口的糟糕使用。** 类在内部使用一些常量，完全属于实现细节。实现一个常量接口会导致这个实现细节泄漏到类的导出API中。更糟糕的是，它代表了一个承诺：如果在将来的版本中修改了类，不再需要使用常量，那么它仍然必须实现接口，以确保二进制兼容性。如果一个非final类实现了常量接口，那么它的所有子类命名空间都会被接口中的常量所污染。

> ### 如果你想导出常量，有几个合理的选择方案：

接口只能用来定义类型。它们不应该仅用于导出常量
- 1. 如果常量与现有的类或者接口紧密相关，则应将其添加到该类或接口中。
- 2. 如果常量最好被看作枚举类型成员，则应该使用枚举类型导出它们。
- 3. 你应该用一个不可实例化的工具类导出常量。(私有构造方法)

## 23. 类层次结构优于标签类

## 24. 支持使用静态成员类而不是非静态类

四种嵌套类：
- 1. 静态成员类
- 2. 非静态成员类
- 3. 匿名类
- 4. 局部类
除第1种外，其它三种都被称为内部类（inner class）

如果你声明了一个不需要访问宿主实例的成员类，问题把static修饰符放在它的声明中，全它成为一个静态成员类，而不是非静态成员类。忽略了这个修饰符，每个实例都会有一个隐藏的外部引用给它的宿主实例。如前所述，存储这个引用需要占用时间和空间。更严重的时，会导致宿主类在满足垃圾回收的条件时却仍然驻留内存中。由此产生的内存泄漏可能是灾难性的。由于引用是不可见的，所以通常难以检测到。

## 25. 将源文件限制为单个顶级类

如果试图将多个顶级类放入单个源文件中，请考虑使用静态成员类，作为将类拆分为单独的源文件替代方法。
永远不要将多个顶级类或接口放在一个源文件中，遵循这个规则保证在编译时不能有多个定义。这又保证了编译生成的类文件以及生成的程序行为与源文件传递给编译器顺序无关。

## 26. 不要使用原始类型（没有类型参数的泛型）

在编译完成之后尽快的发现错误是值得的，理想情况是在编译时。如果使用原始类型，则会丧失泛型的所有安全性和表达上的优势。
泛型有子类型规则，`List<String>`是原始类型`List`的子类型，但不是参数化类型`List<Object>`类型的参数。

## 27. 消除非检查警告

尽可能的消除每个未经过检查的警告，如果你不能消除警告，但你可以证明引发警告的代码是类型安全的，那么（并且只能这样用）@SuppressWarnings("unchecked")注解来消除警告。每当使用@SuppressWarning("unchecked")注解时，请添加注解，说明为什么是安全的。

## 28. 列表优于数组

## 29. 优先考虑泛型

## 30. 优先使用泛型方法

## 31. 通过限定通过符来增加API的灵活性







