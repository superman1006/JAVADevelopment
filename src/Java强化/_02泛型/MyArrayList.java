package Java强化._02泛型;

import java.util.ArrayList;

// 自定义泛型类，泛型接口也是类似的,E,T,K,V都可以作为类型参数的标识符，通常使用大写字母表示
public class MyArrayList<E> {
    private ArrayList<E> arrayList = new ArrayList<>();
}
