package Java基础._03单例设计模式;

public class Main {
    public static void main(String[] args) {
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        System.out.println(a1 == a2); // true
    }
}
