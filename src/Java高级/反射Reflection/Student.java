package Java高级.反射Reflection;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    // 私有的构造器
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(name + "学生在吃饭");
    }

    private void eat(String food){
        System.out.println(name + "学生在吃" + food);
    }

}
