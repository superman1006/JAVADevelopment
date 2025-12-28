package Java基础._04抽象类Abstract;

public class Main {
    public static void main(String[] args) {
        // 1.抽象类不能被实例化\
        // Father father = new Father(); // 错误写法
        // 2.抽象类的抽象方法 必须 被子类重写!

        Father son = new Son();
        son.setName("张三");
        son.setAge(18);
        son.show();
    }
}
