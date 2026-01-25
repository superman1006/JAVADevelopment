package Java高级._03注解Annotation;


import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Main {
    static void main() {
        // 注解(Annotation)是java中的特殊标记,如@Test,@Override等
        // 注解作用: 告诉程序根据注解星系来决定怎么执行该程序
        // 注解本质是接口,extends 了 Annotation 接口,里面的参数其实是接口中的抽象方法
    }

    @MyBook(name = "cl", age = 22, address = {"beijing", "shanghai"})
    public static void A(){
        System.out.println("Hello A");
    }

    @A("xxx")
    public static void B(){
        System.out.println("Hello A");
    }


    @Test
    public static void parseClass() throws Exception{
        // 解析注解
        Class cls = Main.class;

        // 得到指定方法
        Method method = cls.getDeclaredMethod("A");

        // 获取方法上的注解@MyBook
        MyBook myBook = method.getDeclaredAnnotation(MyBook.class);

        // 获取注解中的参数值
        System.out.println("name: " + myBook.name());
        System.out.println("age: " + myBook.age());

        System.out.println();
    }
}
