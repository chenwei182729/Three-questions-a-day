public class OverrideTest{
    public void info(String name,double count){
        System.out.println("name参数为:"+name);
        System.out.println("count参数为:"+count);
    }
    public static void main(String[] args){
        OverrideTest ot = new OverrideTest();
        //试图调用ot的info方法
        ot.info("crazyit.org",5);
    }    
}