public class StringTest1{
    public static void main(String[] args){
        //str1的值是字符串直接量
        //因此，str1指向字符串缓存沲中的"Hello Java"字符串
        String str1 = "Hello Java";
        String str2 = "Hello Java";
        //下面程序将输出true
        System.out.println(str1 == str2);
    }
}

