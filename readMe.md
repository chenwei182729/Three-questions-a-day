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

