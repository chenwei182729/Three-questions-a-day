public class ImmutableString{
    public static void main(String[] args) {
        //定义一个字符中变量
        String str = "Hello";
        System.out.println(System.identityHashCode(str));
         str += "java";
        System.out.println(System.identityHashCode(str));
        str += ",crazyit.org";
        System.out.println(System.identityHashCode(str));
    }
}