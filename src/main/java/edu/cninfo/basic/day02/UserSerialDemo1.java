package edu.cninfo.basic.day02;

import edu.cninfo.basic.vo.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 实现Serializable接口的类才能序列化
 */
public class UserSerialDemo1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user = new User("chenxinwei", "password", "male", 20);
        oos.writeObject(user);
        System.out.println(user);
        System.out.println(user.show());
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user2 = (User) ois.readObject();
        System.out.println(user2);
        System.out.println(user2.show());
    }
}
