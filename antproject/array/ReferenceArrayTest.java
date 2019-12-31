public class ReferenceArrayTest{
    public static void main(String[] args){
        Person[] students = new Person[2];
        Person person1 = new Person(1,1.0);
        students[0]=person1;
        person1.info();
        Person person2 = new Person(2,2.0);
        person2.info();
        students[1]=person2;
        
        students[0].info();
        students[1].info();
    }
}