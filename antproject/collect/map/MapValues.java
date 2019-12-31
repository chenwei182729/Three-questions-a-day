import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapValues {
    public static void main(String[] args){
        Map<String,Double> scores = new HashMap<String,Double>();
        scores.put("语文",89.0);
        scores.put("数学",83.0);
        scores.put("英文",80.0);
        System.out.println(scores.values());
        System.out.println(scores.values().getClass());
        
        Map<String,Double> health = new TreeMap<String,Double>();
        health.put("身高",173.0);
        health.put("体重",71.2);
        System.out.println(health.values());
        System.out.println(health.values().getClass());

        health.put("年龄",27.0);
        System.out.println(health.values());
        System.out.println(health.values().getClass());
    }
}