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





















