public class SwitchTest{
    public static void main(String[] args) {
        String s1 = "!~";
        String s2 = "\"_";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        switch (args[0]){
            case s1:
                System.out.println(s1);
                break;
            case s2:
                System.out.println(s2);
                break;
        }
    }
}