package Java强化._06多线程;

import java.util.concurrent.*;

/**
 * 创建线程池方式一(推荐使用):用 ThreadPoolExecutor 构造方法创建线程池
 * ThreadPoolExecutor 线程池的常用参数：
 *      corePoolSize：核心线程数，即线程池中始终保持活动的线程数(通常是 CPU 核心数)
 *      maximumPoolSize：最大线程数,即线程池中允许的最大线程数(包括核心线程)
 *      keepAliveTime：线程空闲时间,即当线程池中的线程数量超过核心线程数时，多余的空闲线程在终止前等待新任务的最长时间
 *      unit：keepAliveTime的时间单位,如 TimeUnit.SECONDS
 *      workQueue：任务队列,用于存放  "等待执行"（不是正在execute 的任务）的任务(Runnable 的实现类对象)
 *      threadFactory：线程工厂,用于创建线程，一般使用默认即可
 *      handler：拒绝策略,当线程池和任务队列都满时，如何处理新任务,一般默认即可
 */

public class Main7_ThreadPoolCreation {
    static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool1 = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

//      1.处理 Runnable 任务
        Runnable task1 = new myTaskRunnable();
        // .execute() 执行任务，会创建线程来执行task任务,执行后线程不会销毁，而是放入线程池中等待下一个任务
        pool1.execute(task1);
        pool1.execute(task1);
        pool1.execute(task1);




//===================================================================


        ExecutorService pool2 = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


//      2.处理 Callable 任务
        Callable<String> task2 = new myTaskCallable();
        Future<String> f1 = pool2.submit(task2);
        Future<String> f2 = pool2.submit(task2);
        Future<String> f3 = pool2.submit(task2);

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

    }
}


// 可运行的任务,实现 Runnable 接口
class myTaskRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+": " + i);
        }
    }
}

// 可返回结果的任务,实现 Callable 接口
class myTaskCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return Thread.currentThread().getName() + " is over.";
    }
}

