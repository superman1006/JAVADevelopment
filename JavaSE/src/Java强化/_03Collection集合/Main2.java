package Java强化._03Collection集合;

import java.util.*;


//==================================Iterator迭代器==================================
public class Main2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Hello1");
        list.add("World1");

//      小技巧: 输入list.iterator()后加.var再回车可以快速获得变量
        Iterator<String> it = list.iterator();
//      ===it迭代器位于 集合的!!!!第一个元素之前!!!===
//          [1, 2, 3, 4]
//       it

        while (it.hasNext()) {
            System.out.println(it.next());
        }


//      =================删除元素的情况==================
//      如果在fori中使用list.remove(i)时,可能会出现删除i号元素后，i指向当前删除的位置,
//      但是list会自动把后续的元素前移,导致跳过了一个元素,这是有需要自己手动i--,很麻烦
//      所以:  遇到删除的情况尽量用迭代器it去删除,因为it.remove()后会自动校准到下一个该遍历的元素!!!!!
        it.remove();
    }
}
