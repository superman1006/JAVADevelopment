package Java强化._06多线程;

public class Main4_ThreadMethod {
    static void main(String[] args) {
        /**
         * 1. t1.getName():获取线程的名称
         * 2. t1.setName():设置线程的名称
         * 3. Thread.currentThread():静态方法，返回当前线程对象的引用
         * 4. Thread.sleep(1000ms = 1s):使当前正在执行的线程休眠指定的毫秒数
         * 5. t1.join():理解为"插队",在A线程中调用B线程的join()方法，
         *      A线程进入阻塞状态，直到B线程完全执行完以后，A线程才结束阻塞状态
         */
        Thread current = Thread.currentThread();
        System.out.println("Main Thread Name:"+current.getName());
        System.out.println("主线程的名字永远是 main\n");

        Thread t1 = new myThread("a");
        t1.setName("子线程1");
        t1.start();
        System.out.println("ThreadName of t1:" + t1.getName());

        Thread t2 = new myThread("b");
        t2.setName("子线程2");
        t2.start();
        System.out.println("ThreadName of t2:" + t2.getName());
    }
}

class myThread extends Thread{
    public myThread(String name){
        super(name); // 调用父类的构造方法设置线程名称
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " is running:"+i);
        }
    }
}
