public class SwitchTest4{
    public static void main(String[] args) {
        args=new String[]{"world"};
        final String s1 = "hello";
        final String s2 = "world";
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