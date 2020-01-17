import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Skip{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        List<String> result = list.stream()
            .skip(1)
            .collect(Collectors.toList());
        
        System.out.println(result);
    }
}