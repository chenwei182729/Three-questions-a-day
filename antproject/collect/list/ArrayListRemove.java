import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        for(Iterator<String> it = list.iterator();it.hasNext();){
            String ele = it.next();
            //当迭代倒数第2个元素时
            if(ele.equals("333")){
                list.remove(ele);
            }
            System.out.println(ele);
        }
    }
}