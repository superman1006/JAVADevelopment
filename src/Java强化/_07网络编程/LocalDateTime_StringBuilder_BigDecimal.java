package Java强化._07网络编程;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime_StringBuilder_BigDecimal {
    static void main() {
        //========================基础==========================



        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间: " + now);
        // 格式化时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化后的时间: " + now.format(dtf));






        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("abc");
        }
        String result = sb.toString();
        System.out.println(result);







        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b); // 0.30000000000000004 会出现浮点数计算失真
        // 必须使用字符串!!
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        // 加法
        BigDecimal c1 = a1.add(b1);
        double c = c1.doubleValue();
        System.out.println(c1); // 0.3
        // 除法
        BigDecimal d1 = a1.divide(a1,3, RoundingMode.HALF_UP); // 保留2位小数，四舍五入
        System.out.println(d1); // 1.00
    }
}
