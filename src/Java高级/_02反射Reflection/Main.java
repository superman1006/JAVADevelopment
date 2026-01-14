package Java高级._02反射Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    static void main() throws Exception {
        // 反射就是: 加载类,并允许以编程的方式去解剖类中的各种成分(成员变量,方法,构造器,注解等)


//  =================================1. 获取 Class 对象=================================
        // 一. 获取 Class 对象的三种方式:
        // 1. 通过类名.class 获取
        Class c1 = Student.class;
        System.out.println("c1: " + c1);

        // 2. 通过对象的 getClass() 方法获取
        Student s1 = new Student();
        Class c2 = s1.getClass();
        System.out.println("c2: " + c2);

        // 3. 通过 Class.forName("全类名") 获取
        Class c3 = Class.forName("Java高级._02反射Reflection.Student");
        System.out.println("c3: " + c3);
        // 说明: 以上三种方式获取到的 Class 对象是同一个对象
        System.out.println(c1 == c2); // true
        System.out.println(c2 == c3); // true
        System.out.println("================================================================");



//  =================================2. 获取 Class的信息=================================

        // 1. 获取全类名
        System.out.println("c1.getName()" + c1.getName());
        System.out.println("c1.getSimpleName()" + c1.getSimpleName());




        // 2. 获取all构造器
        // 加了 Declared 之后,可以得到 public + private 的构造器
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor cons : constructors) {
            System.out.println("constructor: " + cons);
        }
        // 2.1 获取无参数构造器
        Constructor con1 = c1.getDeclaredConstructor();
        System.out.println("no-arg constructor: " + con1);
        // 2.2 获取有参数构造器（获取第一个参数是 String,第二个参数是 int 的构造器）
        Constructor con2 = c1.getDeclaredConstructor(String.class, int.class);
        System.out.println("arg constructor: " + con2);




        // 3. 获取成员变量
        Field[] fields = c1.getDeclaredFields();
        for (Field field :fields) {
            System.out.println(field.getName()+" : "+field.getType().getName());
        }
        // 3.1 获取指定名字的成员变量
        Field field = c1.getDeclaredField("name");
        System.out.println("field: " + field.getName()+" : " + field.getType().getName());





        // 4. 获取all成员方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method: " + method);
        }
        // 4.1 获取指定名字和参数的成员方法
        Method m1 = c1.getDeclaredMethod("eat");
        System.out.println("method: " + m1);
        Method m2 = c1.getDeclaredMethod("eat", String.class);
        System.out.println("method: " + m2);
        System.out.println("================================================================");



//  =================================3.获取信息后的操作!!!!!!=================================

        // 虽然 con2构造器 是私有的,但是可以通过反射修改访问权限()!
        con2.setAccessible(true); // 暴力访问,取消访问检查
        Student stu1 = (Student) con2.newInstance("cl",22); // 通过无参构造器创建对象



        // 虽然 field 成员变量 是私有的,但是可以通过反射修改访问权限!
        field.setAccessible(true);
        field.set(stu1, "cll"); // 通过反射给成员变量赋值
        System.out.println(field.get(stu1));


        // 虽然 m2 成员方法 是私有的,但是可以通过反射修改访问权限!
        m2.setAccessible(true);
        m2.invoke(stu1, "rice");// 通过反射调用成员方法

    }
}
