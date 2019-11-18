package edu.cninfo.basic.day05;

import edu.cninfo.common.vo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        User user1 = (User) acc.getBean("user");
        User user2 = (User) acc.getBean("user2");
        User user3 = (User) acc.getBean("user3");
        User user4 = (User) acc.getBean("user4");
        Logger.getGlobal().info(user1.string());
        Logger.getGlobal().info(user2.string());
        Logger.getGlobal().info(user3.string());
        Logger.getGlobal().info(user4.string());
        Logger.getGlobal().info(user1.toString());
        Logger.getGlobal().info(user2.toString());
        Logger.getGlobal().info(user3.toString());
        Logger.getGlobal().info(user4.toString());
    }
}
