package Java强化._06多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main8_ThreadpoolCreation {
    public static void main(String[] args) {
        /**
         * 创建线程池方式二(不推荐):使用 Executors 工具类创建线程池(底层依旧是 ThreadPoolExecutor)
         * Executors 提供了多种静态方法来创建不同类型的线程池：
         *     newFixedThreadPool(int nThreads)：创建一个固定大小的线程池
         *     newSingleThreadExecutor()：创建一个单线程的线程池
         *     newCachedThreadPool()：创建一个可缓存的线程池,线程数量随需增长
         *
         * 可以和 ThreadPoolExecutor(第一种方式)一样地使用这些线程池来执行 Runnable 或 Callable 任务
         */

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new tempTask());
        pool.execute(new tempTask());
        pool.execute(new tempTask());
        pool.execute(new tempTask());
    }
}

// 可运行的任务,实现 Runnable 接口
class tempTask implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=3;i++){
            System.out.println(Thread.currentThread().getName()+": " + i);
        }
    }
}


