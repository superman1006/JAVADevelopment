package Java强化._01异常Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "2025-12-16 11:22:33";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);


        try{
            System.out.println(div(10, 0));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("程序结束");


    }
    public static int div(int a,int b) throws Exception{
        if(b == 0){
            System.out.println("被除数不能为0");
            throw new RuntimeException("除数不能为0!!!");
        }
        return a/b;
    }
}
