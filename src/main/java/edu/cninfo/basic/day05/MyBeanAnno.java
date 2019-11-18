package edu.cninfo.basic.day05;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Bean
/**
 * @author chenxinwei
 * 注解的组合
 **/
public @interface MyBeanAnno {
    @AliasFor(annotation = Bean.class, attribute = "value")
    String[] beanName() default {
    };
}
