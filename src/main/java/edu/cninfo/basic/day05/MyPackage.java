package edu.cninfo.basic.day05;

import java.lang.annotation.*;

@Target({ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyPackage {
    String packageName() default "default";
}

