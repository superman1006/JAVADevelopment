package Java高级.注解Annotation;




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
}
