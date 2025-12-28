package Java基础._11ArrayList数组;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
//        数组的长度时固定的,如果需要一个可变长度的数组,可以使用ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("初始大小:"+arrayList.size());

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("添加3个元素后大小:"+arrayList.size());

        System.out.println("第2个元素:"+arrayList.get(1));

        arrayList.remove(1);
        System.out.println("删除第2个元素后大小:"+arrayList.size());

        arrayList.set(1, 50);
        System.out.println("第2个元素是:"+arrayList.get(1));
    }
}
