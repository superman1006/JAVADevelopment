package Java高级._03注解Annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 两个重要的元注解(注解注解的注解): Target 和 Retention
@Target(ElementType.METHOD) // 添加了 Target 注解, ElementType.METHOD 表示该注解只能用于方法上
@Retention(RetentionPolicy.RUNTIME) // 添加了 Retention 注解, RetentionPolicy.RUNTIME 表示该注解在运行时仍然可用
public @interface MyBook {
    // 自定义注解
    String name();
    int age() default 18;
    String[] address();
}
