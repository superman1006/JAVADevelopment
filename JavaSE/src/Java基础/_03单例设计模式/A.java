package Java基础._03单例设计模式;

import lombok.Data;


//单例模式分为饿汉式和懒汉式
//      饿汉式: 类加载时就创建对象,线程安全,但是不管用都占内存
//      懒汉式: 需要时才创建对象,节省内存,但是线程不安全
//下面是懒汉式的单例模式实现(懒汉式是最常用的单例模式实现)

@Data
public class A {
    // 1.私有化构造器
    private A(){
    }
    // 2.创建类的唯一static实例
    private static A a;

    // 3.提供一个公共的静态方法，返回类的唯一实例
    public static A getInstance(){
        if(a == null){
            a = new A();
        }
        return a;
    }
}
