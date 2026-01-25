package Java基础._05模板设计模式;

// 模板设计模式:
public class Main {
    public static void main(String[] args) {
        People student = new Student();
        student.printInfo();

        System.out.println("------------");

        People teacher = new Teacher();
        teacher.printInfo();
    }
}
