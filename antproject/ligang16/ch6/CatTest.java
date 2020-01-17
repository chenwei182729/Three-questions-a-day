class Cat{
    private static long instanceCount = 0;
    public Cat(){
        System.out.println("no parameter constructor");
        instanceCount++;
    }
    public static long getInstanceCount(){
        return instanceCount;
    }
}

public class CatTest{
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            Cat cat = new Cat();
        } 
    }    
}