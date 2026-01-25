package Java基础._09匿名内部类和Lambda;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("匿名内部类其实就是一个没有名字的类(但是其实有名字:原类名$1,原类名$2...)");
        System.out.println("匿名内部类的语法: new 父类名或接口名(){重写方法...};");
        System.out.println("Animal是abstract的,不能直接创建对象,但是可以创建一个匿名内部类继承Animal然后,并重写方法");
        System.out.println("!!匿名内部类本质是:创建了一个新类extends Animal,并重写了cry方法,然后又创建了这个新类的对象");

        Animal animal = new Animal() {
            @Override
            public void cry() {
                System.out.println("动物叫");
            }
        };
        animal.cry();

        System.out.println("应用场景:匿名内部类常作为一个临时对象传入函数");

    }
}

abstract class Animal {
    public abstract void cry();
}