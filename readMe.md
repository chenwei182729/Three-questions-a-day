# 每天三道题

## Day01 代理

### 1.代理Integer类，查看binarySearch的查找路径

#### Proxy

```
     static Object	newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
     Returns an instance of a proxy class for the specified interfaces that dispatches method invocations to the specified invocation handler.
```
  
#### Interface InvocationHandler

```
    Object	invoke(Object proxy, Method method, Object[] args)
    Processes a method invocation on a proxy instance and returns the result.
```

## Day02 序列化和反序列化

### 实现 Serializable接口的类才能序列化和反序列化
### 序列化对单例的破坏以及预防
### 反射对单例的破坏以及预防

## Day03 枚举与Switch

### 枚举

1. 每个枚举类型都有固定的实例集
2. 每个枚举类型E，自动实现了Comparable<E>,仅允许比较它自己的对象，这种比较是基于充数值的。
3. 每个枚举类型实例保证只被构造一次。（枚举类型的构造函数问题私有的）
4. 枚举类可以拥有静态成员，但是要小心构造的次序。由于常量在静态成员之前构造，所以，你不能在构造函数里引用任何静态成员。（在静态代码块中构造）

### 运行时类型信息

1. 程序运行时查询一个对象属于哪个类
2. Class类
    - Class.forName方法主要用于构造那些在编译时还不被知晓的Class对象。如果提前知道需要哪一个类，就用该类的名称。
    - Class<?> cl2 = String[].class
    - Class<?> cl3 = Runnable.class
    - Class<?> cl4 = int.class
    - Class<?> cl5 = void.class
3. 虚拟机为每种类型管理一个唯一的Class对象。（你可以用==操作符来比较类对象）
4. 资源加载（定位应用程序可能需要的资源，比如配置文件或者图片，如果将资源与类文件放在同一个位置，则可以你这样打开一个输入流）

```
    InputStream stream = MyClass.class.getResourceAsStream("config.txt");
    Scanner in = new Scanner(stream);
```
### 类加载器 （负责加载字节流，并且在虚拟机中将它们转化成一个类或者接口）

虚拟机指令存储在类文件。每个类文件包含单个类或者接口的指令。类文件存放的位置：
1. 文件系统里
2. JAR文件里
3. 远程某个位置
4. 内存中动态构建

**三个类加载器**
- bootstrap类加载器会加载Java类库（一般来自于jre/lib/rt.jar文件）。它是虚拟机的一部分。
- 扩展类加载器从jre/lib/ext目录中加载“标准库扩展”部分。
- 系统类加载器加载应用程序类。它定位classpath目录和JAR文件的类

#### 一个类中包含如下几类东西，他们前后是有顺序关系的

1. 静态属性：static 开头定义的属性
2. 静态方法块： static {} 圈起来的方法块
3. 普通属性： 未带static定义的属性
4. 普通方法块： {} 圈起来的方法块
5. 构造函数： 类名相同的方法
6. 方法： 普通方法

## Day04 MyBatis源码阅读

### 模拟mybatis3.5.3 LogFactory加载logger
> 说明：Runnable接口的用法

## Day05 注解

Ehcache注解缓存了解到注解的组合用法

















