package Java强化._04Stream流;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {

//        Stream流大量的结合了Lambda表达式,可以极大的简化代码,多线程操作也变得非常简单

        List<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张xx");
        list.add("张x");
        list.add("张");
        list.add("陈xx");
        list.add("陈x");
        list.add("陈");

//      把姓张的人且名字为3个字的,存入一个新的集合中

//      传统方法:
        List<String> new_list1 = new ArrayList<>();
        for(String str : list){
            if(str.startsWith("张") && str.length() == 3){
                new_list1.add(str);
            }
        }
        System.out.println(new_list1);



//      Stream流方法:
//        流程:先获取Stream流->过滤->收集到新的集合
//            list.stream()  //把list转换成Stream流,相当于一个传送带，每个元素都在这个传送带上
//            .filter(name -> name.startsWith("张")) //过滤,只留下姓张的,其他的都丢弃
//            .filter(name -> name.length() == 3) //再过滤,只留下名字为3个字的,其他的都丢弃
//            toList(); //把流中的元素收集到一个新的List集合中
//      Java16以后可以使用.toList()代替.collect(Collectors.toList())
        List<String> new_list2 = list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .toList();

        System.out.println(new_list2);

        String[] names = {"张三丰","张xx","张x","张","陈xx","陈x","陈"};
//      数组也可以转换成Stream流
        List<String> new_list3 = Arrays.stream(names)
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .toList();
        System.out.println(new_list3);


        String a = list.stream().max((s1,s2)->s1.length()-s2.length()).get();

    }
}
