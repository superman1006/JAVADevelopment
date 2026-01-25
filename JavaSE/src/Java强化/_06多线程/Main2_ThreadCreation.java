package Java强化._06多线程;

public class Main2_ThreadCreation {
    static void main(String[] args) {
        Runnable ra = new MyRunnable();
        Thread mt = new Thread(ra);
        mt.start(); //启动线程，调用 run 方法


//      （推荐）也可以用匿名类的lambada方式实现 Runnable 接口
        Thread mt2 = new Thread(() -> {
            for(int i=0;i<5;i++){
                System.out.println("线程2:"+i);
            }
        });
        mt2.start();


        for(int i=0;i<5;i++){
            System.out.println("线程3:"+i);
        }
    }

}
//  实现多线程的第二种方式： 实现 Runnable 接口
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("线程1:"+i);
        }
    }
}