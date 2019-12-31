public class Person{
    private int age;
    private double height;

    public void info(){
        System.out.println("age["+age+"],height["+height+"]");
    }

    public Person(int age,double height){
        this.age = age;
        this.height = height;
    }
}