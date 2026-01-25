package Java基础._07接口Interface解耦合;

public class Main {
//  当一个公司A需要处理学生数据时,可以选择实现不同的接口来满足不同的需求.
//  公司A提供ClassDataInter接口的实现,要求有1.打印所有学生信息 和 2.计算平均分的功能.
//  公司B和C可以分别实现ClassDataInter接口,A公司可以直接使用B和C公司的实现来处理学生数据.
//  A公司的代码Main.java可以不需要大量修改代码，而只需要修改B为C即可.这就是接口的好处:解耦合
    public static void main(String[] args) {
        Student[] Students = new Student[5];
        Students[0] = new Student("Alice", 10, 85.5);
        Students[1] = new Student("Bob", 20, 90.0);
        Students[2] = new Student("Charlie", 25, 78.0);
        Students[3] = new Student("Danny", 29, 98.0);
        Students[4] = new Student("Erik", 45, 88.0);
        ClassDataInter companyB = new CompanyB(Students);
        ClassDataInter companyC = new CompanyC(Students);

        companyB.printAllStudentInfo();
        companyB.printAverageScore();
        System.out.println("-----------------------");
        companyC.printAllStudentInfo();
        companyC.printAverageScore();

    }
}
