package Java基础._08接口JDK8后新增的方法;

public interface A {
//  1.实例方法，用default修饰，函数体内可以有具体实现,子类不需要重写，可以直接使用
    default void go() {
        System.out.println("A go()");
    }

//  2.私有方法，使用private关键字修饰，只能在接口内部被调用
    private void info() {
        System.out.println("A info()");
    }

//  3.静态方法，使用static关键字修饰，可以通过接口名直接调用
    static void show() {
        System.out.println("A show()");
    }
}
