package Java强化._06多线程;

public class Main1_ThreadCreation {
    static void main(String[] args) {
        Thread mt = new MyThread();
        mt.start(); //启动线程，调用 run 方法

        for(int i=0;i<5;i++){
            System.out.println("线程2:"+i);
        }

    }

}

//  实现多线程的第一种方式：继承 Thread 类
class MyThread extends Thread{
    @Override //重写 run 方法
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("线程1:"+i);
        }
    }
}