package Java强化._02泛型;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//      =================================1.泛型基础==============================
//      泛型定义:public class 类名<类型参数1,类型参数2...>{}
//      作用:可以让类支持多种数据类型,提高代码的复用性
//      如果不使用泛型,类中的数据类型只能是Object,这样会导致类型转换异常
//      使用泛型后,可以指定类中的数据类型,避免类型转换异常

        ArrayList list1 = new ArrayList();
        list1.add(10); // int
        list1.add("10");// String
        list1.add(10.1);// double





//      =================================2.泛型方法==============================
        String[] strs = {"a","b","c"};
        Integer[] ints = {1,2,3};
        printArrayInfo(strs);
        printArrayInfo(ints);





//      =================================3.通配符?==============================

//      1.泛型<E,K,T,V>  本质是在 "定义"一个类型,E,K,T,V都是类型变量
//      2.  通配符<?>    本质是在 "使用"一个类型,?表示未知类型
//             (多用) 通配符上限<? extends 类名1>  表示 只能使用 类名1及其子类 作为类型
//             (少用) 通配符下限<?  super  类名2>  表示 只能使用 类名2及其父类 作为类型

        ArrayList<BYD> list2 = new ArrayList<>();
        go(list2);
        ArrayList<XIAOMI> list3 = new ArrayList<>();
        go(list3);

    }




//    泛型方法定义
//    在void前面写的<T>代表 " 定义了一个泛型T " ,然后在后面()中使用T,(其中返回类型void也可以使用T)
//    好处:这个方法就可以接收任意的数组类型的变量作为形参,这样不管是什么类型的数组,这个方法都可以使用
    public static <T> void printArrayInfo(T[] strs){
        for (T str : strs){
            System.out.print(str);
        }
        System.out.println();
    }

//    通配符?的使用
    public static void go(ArrayList<? extends Car> List){
        System.out.println("go 方法被调用");
    }
}
