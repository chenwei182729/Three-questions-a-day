public class SwitchTest2{
    public static void main(String[] args) {
        args=new String[]{"\"_"};
        final String s1 = "!~";
        final String s2 = "\"_";
        switch (args[0]){
            case s1:
                System.out.println(s1);
                break;
            case s2:
                System.out.println(s2);
                break;
            default:System.out.println("default");
                break;
        }
    }
}