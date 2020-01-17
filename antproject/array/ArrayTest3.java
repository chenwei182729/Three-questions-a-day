import java.util.Arrays;
public class ArrayTest3{
    public static void main(String[] args) {
        //定义并初始化nums数组
        int[] nums = new int[]{3,5,20,12};
        //定义一个prices数组变量
        int[] prices = nums;
        for(int i:prices){
            System.out.print(" "+i);
        }
        System.out.println("\n==========after change=============");
        prices[2]=34;
        for(int i:prices){
            System.out.print(" "+i);
        }
        
    }
}