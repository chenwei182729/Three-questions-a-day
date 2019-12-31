# 表达式陷井

System提供的identityHashCode()静态方法用于获取某个对象唯一的hashCode值，这个identityHashCode()
的返回值与该类是否重写了hashCode()方法无关。只有当两个对象相同时，它们的identityHashCode值才会相等。