package Java基础._04抽象类Abstract;


public class Son extends Father {

    @Override
    public void show() {
        System.out.println("姓名: " + name + ", 年龄: " + age);
    }
}
