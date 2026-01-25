package Java基础._07接口Interface解耦合;

public class CompanyC implements ClassDataInter{
    private Student[] students;

    public CompanyC(Student[] students){
        this.students = students;
    }

    @Override
    public void printAllStudentInfo() {
        System.out.println("CompanyC正在打印所有学生信息...");
        for (Student student : students) {
            System.out.println("姓名: " + student.getName() + ", 年龄: " + student.getAge() + ", 分数: " + student.getScore());
        }

    }

    @Override
    public void printAverageScore() {
        System.out.println("CompanyC正在打印所有学生平均分...");
        double total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        System.out.println("平均分为" + total);
    }
}
