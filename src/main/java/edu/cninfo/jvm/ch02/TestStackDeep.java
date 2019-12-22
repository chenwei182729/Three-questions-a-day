package edu.cninfo.jvm.ch02;

/**
 * -Xss128K
 */
public class TestStackDeep {
    private static int count = 0;
    public static void recursion(){
        count++;
        recursion();
    }

    public static void recursion(long a,long b,long c){
        count ++;
        recursion(a,b,c);
    }
    public static void main(String[] args) {
       try {
           recursion(1,2,3);
       }catch (Throwable e){
           System.out.println("deep of calling = " + count);
           e.printStackTrace();
       }
    }
}
