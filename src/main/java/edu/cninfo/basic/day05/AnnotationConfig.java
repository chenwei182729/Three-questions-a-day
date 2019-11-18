package edu.cninfo.basic.day05;

import edu.cninfo.common.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {

    @Bean(name = "user")
    public User createUser() {
        return new User("userName1", "password", "F", 10);
    }
    @Bean(name = "user2")
    public User createUser2() {
        return new User("userName1", "password", "F", 10);
    }

    /**
     * 使用@MyBeanAnno和@Bean达到一样的效果
     * @return
     */
    @MyBeanAnno(beanName = "user3")
    public User createUser3() {
        return new User("userName1", "password", "F", 10);
    }

}
