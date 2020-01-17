import java.util.Arrays;
public class ArrayTest1{
    public static void main(String[] args) {
        String[] books = new String[]{"book1","book2","book3","book4","book5"};
        String[] names = {"name1","name2","name3"};

        String[] strArr = new String[5];
        System.out.println(Arrays.toString(books));
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(strArr));
        
    }
}