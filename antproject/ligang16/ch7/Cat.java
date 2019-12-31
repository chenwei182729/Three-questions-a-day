public class Cat{
    private String name;
    private double weight;
    private String color;
    public void Cat(){
        this.name="Garfield";
        this.weight = 20;
        this.color = "orange";
    }

    public void say(){
        System.out.println("weight:"+weight+",color:"+color);
        System.out.println("say hello");
    }
    public static void main(String[] args){
       Cat cat = new Cat();
       cat.say();
       cat.Cat();
       cat.say();
    }    
}