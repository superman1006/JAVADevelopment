package Java基础._01Class重要小技巧;


public class Main {
    public static void main(String[] args) {
        // NoArgsConstructor生成的无参构造方法
        Card card1 = new Card();
        // AllArgsConstructor生成的有参构造方法
        Card card2 = new Card("0001","chenlv","13620413695",200.0);

        System.out.println(card2.getName());
        System.out.println(card2.getPhone());
    }
}
