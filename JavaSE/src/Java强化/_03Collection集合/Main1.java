package Java强化._03Collection集合;

import java.util.*;


//==================================Collection集合==================================
public class Main1 {
    public static void main(String[] args) {

//      1.List是有序(先添加元素在前面),可重复,有索引的集合
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");


//      2. Set是无序,不可重复,没有索引的集合
        Set<String> set = new HashSet<>();
        set.add("Banana");
        set.add("Apple");

        print(list);
        print(set);
    }

    public static <T> void print(Collection<T> collection){
        for(T element: collection){
            System.out.println(element);
        }
    }
}
