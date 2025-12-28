package Java基础._02super应用;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Son son = new Son();
    }


}

class Son extends Father{
    public Son(){
        super();// super()会调用父类的无参数构造器(不写也会自动调用)，如果写成super(xxx)就会调用父类的有参数构造器
        System.out.println("子类构造器");
    }
}

class Father {

    protected String name;
    public Father(){
        System.out.println("父类构造器");
    }
    public Father(int a){
        System.out.println("父类构造器" + a);
    }
}