package Java强化._06多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main3_ThreadCreate {
    static void main(String[] args) {
//      实现多线程的第三种方式：实现 Callable 接口(有 return 返回值)
        myCallable mc = new myCallable(10);

//      FutureTask是Runnable的实现类，可以作为 Thread 线程的参数(和第二种方法相似)
        FutureTask<String> f1 = new FutureTask<>(mc);

        Thread t1 = new Thread(f1);
        t1.start(); //启动线程，调用 run 方法

        try {
            System.out.println(f1.get());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class myCallable implements Callable<String>{
    private int n;
    public myCallable(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for(int i=0;i<=this.n;i++){
            System.out.println("线程1:"+i);
            sum+=i;
        }
        return  "==== sum:" + sum;
    }
}
