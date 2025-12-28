package Java基础._05模板设计模式;

public abstract class People {
    public abstract void writeMain();

    public final void printInfo() {
        System.out.println("论文的开头:xxxxx");
        writeMain();
        System.out.println("论文的结尾:xxxxx");
    }
}
