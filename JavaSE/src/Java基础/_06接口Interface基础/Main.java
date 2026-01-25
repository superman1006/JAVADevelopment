package Java基础._06接口Interface基础;

public class Main {
//    接口不能创建对象
//    接口是被class实现implements的
//    语法:pubic class 类名 implements 接口名1,接口名2...{} (注意:接口可以多实现，类只能单继承)
    public static void main(String[] args) {
        System.out.println(A.SCHOOL_NAME);
        C c = new C();
        c.printInfoA();
        c.printInfoB();

    }

    public static class C implements A,B {

        @Override
        public void printInfoA() {
            System.out.println("A");
        }

        @Override
        public void printInfoB() {
            System.out.println("B");

        }
    }
}
