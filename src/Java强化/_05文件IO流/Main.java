package Java强化._05文件IO流;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        File f1 = new File("D:\\Project\\JAVADevelopment\\src\\Java强化\\_05文件IO流\\a.txt");
        System.out.println(f1.length());//字节大小
        System.out.println(f1.getName());//名字
        System.out.println(f1.isFile());//文件
        System.out.println(f1.isDirectory());//文件夹
        System.out.println(f1.getPath() );

        System.out.println("=============================================");
        File f2 = new File("src\\Java强化\\_05文件IO流\\b.txt");
        System.out.println(f2.exists());
        System.out.println(f2.createNewFile());
        System.out.println(f2.delete());//删除f2


        System.out.println("=============================================");
        File f3 = new File("src\\Java强化\\_05文件IO流\\dir01");
        System.out.println(f3.exists());
        System.out.println("创建dir01:"+f3.mkdirs());
        System.out.println("删除dir01:"+f3.delete());



        System.out.println("=============================================");
        File f4 = new File("src\\Java强化\\_05文件IO流");
        File[] files = f4.listFiles();
        if(files != null){
            for(File file : files){
                System.out.println(file.getName());
            }
        }

        backtrack(new File("D:\\OneDrive\\Desktop\\Notebook"),"Git.txt");
    }

    /**
     * 用于递归 dir 下所有文件
     * @param dir
     * @param filename
     */
    public static void backtrack(File dir,String filename){
        if(dir == null || !dir.exists() || dir.isFile()){
            return;
        }

        File[] files = dir.listFiles();

        if(files.length != 0 && files != null){
            for(File file : files){
                if(file.isFile() && file.getName().equals(filename)){
                    System.out.println("找到了:"+file.getPath());
                    return;
                }else{
                    backtrack(file,filename);
                }
            }
        }
    }
}
