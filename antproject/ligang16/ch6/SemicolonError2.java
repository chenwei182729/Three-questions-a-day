public class SemicolonError2{
    public static void main(String[] args){
       String[] books = {
           "book1",
           "book2",
           "book3"
       };
       int i=0;
       for (;i<books.length;i++){
           System.out.println("index["+i+"]"+books[i]);
       }
    }    
}