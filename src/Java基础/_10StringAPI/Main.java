package Java基础._10StringAPI;


public class Main {
    public static void main(String[] args) {
//      =========================String基础=============================
//      =========================String基础=============================

//      直接用双引号创建的字符串会被放在字符串常量池中，str1和str2指向同一个内存地址(两个相同的参数,修改其中一个会报错，因为字符串常量池中的字符串是不可变的)
//      使用new关键字创建的字符串对象会被放在堆内存中,str3和str4指向不同的内存地址(两个不同的参数)
        String str1 = "Hello World";
        String str2 = "Hello World";
        System.out.println(str1.equals(str2)); // true

        String str3 = new String("Hello World");
        String str4 = new String("Hello World");
        System.out.println(str3.equals(str4)); // false




//      =========================String的常用API=========================

//        .length()
        int length = str1.length();// 11

//        .charAt()
        char str1_0 = str1.charAt(0);// 'H'

//        .toCharArray()
        char[] chars = str1.toCharArray();// ['H','e','l','l','o',' ','W','o','r','l','d']

//        .equals()比较内容是否相同,如果使用==比较,比较的是内存地址是否相同
        boolean bool1 = str1.equals(str2);// true

//        .substring(a, b)
        String str5 = str1.substring(1, 5); // "ello"(!!!!包前不包后!!!!)
        System.out.println(str5);

//        .replace
        String str6 = str1.replace("o","0"); // "Hell0 W0rld"
        System.out.println(str6);

//        .contains
        boolean bool2 = str1.contains("0"); // false

//        .split()
        String[] parts = str1.split(" "); // ["Hello", "World"]
        for (String part : parts) {
            System.out.println(part);
        }


    }
}
