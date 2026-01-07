package Java强化._05文件和IO流;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class MainIO {
    public static void main() throws Exception{
        /**
         * 字节流(适合文本复制)      输入字节流  抽象类InputSteam
         *                        输出字节流  抽象类OutputSteam
         *
         * 字符流(适合读取文件)      输入字节流  抽象类Reader
         *                        输出字节流  抽象类Writer
         *
         *
         * 缓冲流
         *      可以使用 在上面的四个类包装成Bufferedxxx（如 BufferedReader br = BufferedReader(fr);）
         *      这样可以提高读写效率,因为内置 8KB的缓冲区
         *      BufferedReader有一个 readLine() 方法，可以按行读取文本内容
         *      BufferedWriter有一个 newLine() 方法，可以写入一个换行符
         */

//      ====================================================字节流输入====================================================
        InputStream is = new FileInputStream("src/Java强化/_05文件和IO流/a.txt");
//        InputStream bis = new BufferedInputStream(is); //缓冲字节输入流，提高读取效率

//      1. is.read()少用
        int a;
        while((a = is.read())!=-1){
//            is输入字节流对象会每次读入一个字节 Byte, 如果有数据 -> return字节内容，
//                                                没有数据   -> return -1
//            缺点:UTF-8中 中文 是 3 个 Bytes,用字节流会导致中文乱码
            System.out.print((char) a);
        }

        System.out.println("========================");



//      2.  is.readAllBytes() 效率相对 read 好一点，但是中文还是会乱码,适合小文件

        InputStream is1 = new FileInputStream("src/Java强化/_05文件和IO流/a.txt");
        byte[] buffer = is1.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
        is.close();  //关闭流，释放资源

        System.out.println("========================");





//      ====================================================字节流输出====================================================
        OutputStream os = new FileOutputStream("src/Java强化/_05文件和IO流/a.txt",true);
//      append参数为true表示追加写入，false表示覆盖写入

        os.write(97); //写入一个字节  ASCII 码表 97 -> 'a'
        os.write("hello-world\n".getBytes());
        os.close();      //关闭流，释放资源




//      ================================================字节流实现 copy 文件====================================================

//      try-with-resources 语法 自动关闭流，释放资源
//      try(资源声明; 资源声明; ... ) {
//          使用资源的代码
//      } catch(异常类型 变量名) {
//          处理异常的代码
//      }
        try (InputStream is2 = new FileInputStream("src/Java强化/_05文件和IO流/a.txt");
             OutputStream os2 = new FileOutputStream("src/Java强化/_05文件和IO流/b.txt")) {
            byte[] buf = new byte[1024]; //1KB缓冲区
            int len;
            while ((len = is2.read(buf)) != -1) {
                os2.write(buf, 0, len); //写入读取的字节数
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }















//      ====================================================字符流输入====================================================

        try(Reader fr = new FileReader("src/Java强化/_05文件和IO流/char.txt")){
            char[] chs = new char[1024];
            int len = 0;
            while((len = fr.read(chs)) != -1){
                String str1 = new String(chs,0,len);
                System.out.println(str1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("========================");


//      ====================================================字符流输出====================================================

        try(Writer fr = new FileWriter("src/Java强化/_05文件和IO流/char.txt",true)){
            fr.write("'插入一些字符到文件中'\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("========================");










//      ================================================用 IO框架 commons-io来操作====================================================
//      底层是使用上面的流来实现的，简化了代码
//      需要导入 commons-io 的 jar包(官网下载 commons 的jar 包后放到 lib 目录中，然后右键Add as Library 添加到项目中)
        FileUtils.copyFile(new File("src/Java强化/_05文件和IO流/a.txt"),new File("src/Java强化/_05文件和IO流/c.txt"));
        String temp = FileUtils.readFileToString(new File("src/Java强化/_05文件和IO流/c.txt"));
        System.out.println(temp);
    }
}
