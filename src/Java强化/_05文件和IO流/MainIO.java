package Java强化._05文件和IO流;

import java.io.*;

public class MainIO {
    static void main() throws Exception{
        /**
         * 字节流(适合文本内容,复制)  输入字节流  抽象类InputSteam
         *                        输出字节流  抽象类OutputSteam
         *
         * 字符流(适合)             输入字节流  抽象类InputSteam
         *                        输出字节流  抽象类InputSteam
         */

//      ====================================================字节流输入====================================================
        InputStream is = new FileInputStream("/Users/chenlv/Project/JAVAProject/JAVADevelopment/src/Java强化/_05文件和IO流/a.txt");

//      1. is.read()少用
        int a;
        while((a = is.read())!=-1){
//            is输入字节流对象会每次读入一个字节 Byte, 如果有数据 -> return字节内容，
//                                                没有数据   -> return -1
//            缺点:UTF-8中 中文 是 3 个 Bytes,用字节流会导致中文乱码
            System.out.print((char) a);
        }


//      2.  is.readAllBytes() 效率相对 read 好一点，但是中文还是会乱码,适合小文件

        byte[] buffer = is.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
        is.close();  //关闭流，释放资源








//      ====================================================字节流输出====================================================
        OutputStream os = new FileOutputStream("/Users/chenlv/Project/JAVAProject/JAVADevelopment/src/Java强化/_05文件和IO流/a.txt",true);
//      append参数为true表示追加写入，false表示覆盖写入

        os.write(97); //写入一个字节  ASCII 码表 97 -> 'a'
        os.write("\nhello-world\n".getBytes());
        os.close();      //关闭流，释放资源







//      ===================================================字节流实现 copy 文件====================================================

//      try-with-resources 语法 自动关闭流，释放资源
//      try(资源声明; 资源声明; ... ) {
//          使用资源的代码
//      } catch(异常类型 变量名) {
//          处理异常的代码
//      }
        try (InputStream is2 = new FileInputStream("/Users/chenlv/Project/JAVAProject/JAVADevelopment/src/Java强化/_05文件和IO流/a.txt"); OutputStream os2 = new FileOutputStream("/Users/chenlv/Project/JAVAProject/JAVADevelopment/src/Java强化/_05文件和IO流/b.txt")) {
            byte[] buf = new byte[1024]; //1KB缓冲区
            int len;
            while ((len = is2.read(buf)) != -1) {
                os2.write(buf, 0, len); //写入读取的字节数
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
