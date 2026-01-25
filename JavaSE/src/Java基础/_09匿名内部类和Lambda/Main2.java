package Java基础._09匿名内部类和Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Alice", 20);
        students[1] = new Student("Bob", 22);
        students[2] = new Student("Charlie", 19);
        students[3] = new Student("Diana", 21);
        students[4] = new Student("Ethan", 23);

//      1.匿名内部类实现Comparator接口,按照年龄升序排序
        Arrays.sort(students,new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return s1.getAge() - s2.getAge();
            }
        });



//      2.也可以使用Lambda表达式简化代码
//      !!!   lambda只能用于函数式接口(只有一个抽象方法 的 接口)   !!!!!
//      语法:(参数列表) -> {方法体}
//      简化规则: 1.形参类型Student可以省略
//               2.当只有一个形参时可以省略 ()
//               3.当函数体只有一行代码时可以省略 {} 和 ; 和 return

//      由于Comparator接口只有一个抽象方法compare,所以可以使用lambda表达式简化
//      下面这行代码和上面的匿名内部类实现Comparator接口的代码是等价的
//      进一步简化,由于方法体只有一行代码,可以省略大括号和return关键字
        Arrays.sort(students, (s1, s2) -> s1.getAge() - s2.getAge());


//      按照年龄升序输出学生信息
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String name;
    private int age;

}


//这就是一个函数式接口,可以用@FunctionalInterface来注解
@FunctionalInterface
interface inter{
    void say();
}