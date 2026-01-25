package Java强化._06多线程;

public class Main6_ThreadSecuritySolution_synchronized {
    static void main(String[] args) {
        /**
         * 线程的安全问题 解决方案
         * 当多个线程同时修改同一个共享数据时，就会出现线程安全问题（互斥）
         * 解决方法：使用同步机制
         * 1. 同步代码块
         * 2. 同步方法
         * 3. lock锁
         */

        // 小明和小红一起取钱，取同一个账户
        Account account = new Account("002",1000);
        Thread t1 = new DrawThread("小明",account);
        Thread t2 = new DrawThread("小红",account);

        t1.start();
        t2.start();



//       方法一: 同步代码块 (在需要同步的代码前加锁，结束后释放锁)
//        synchronized ()中的内容可以是任意对象，一般使用共享数据作为锁对象
//
//        class Account{
//            private String carId;
//            private double money;
//            public void draw(double drawMoney){
//                String threadName = Thread.currentThread().getName();
//                synchronized (this) {       //这里的 this 对象本身
//                    if(this.money>=drawMoney){
//                        System.out.println(threadName+"取钱成功，已取出：" + drawMoney);
//                        this.money-=drawMoney;
//                        System.out.println(threadName+"取钱成功，取出后剩余：" +  this.money);
//                    }else{
//                        System.out.println(threadName+"取钱失败，余额不足");
//                    }
//                }
//            }
//        }


//      方法二: 同步方法 (在方法前加 synchronized 关键字)
//        public synchronized void draw
//
//        class Account{
//            private String carId;
//            private double money;
//            public synchronized void draw(double drawMoney){
//                String threadName = Thread.currentThread().getName();
//                if(this.money>=drawMoney){
//                    System.out.println(threadName+"取钱成功，已取出：" + drawMoney
//                    );
//                    this.money-=drawMoney;
//                    System.out.println(threadName+"取钱成功，取出后剩余：" +
//                            this.money);
//                }else{
//                    System.out.println(threadName+"取钱失败，余额不足");
//                }
//            }
//        }


//      方法三: Lock锁 (需要手动上锁和释放锁)
//        lock.lock() 和 lock.unlock()实现上锁和解锁,类似 PV操作
//
//        class Account{
//            private String carId;
//            private double money;
//            private final Lock lock = new ReentrantLock(); // 创建锁对象
//            public void draw(double drawMoney){
//                String threadName = Thread.currentThread().getName();
//                lock.lock(); // 上锁
//                try {
//                    if(this.money>=drawMoney){
//                        System.out.println(threadName+"取钱成功，已取出：" + drawMoney);
//                        this.money-=drawMoney;
//                        System.out.println(threadName+"取钱成功，取出后剩余：" +  this.money);
//                    }else{
//                        System.out.println(threadName+"取钱失败，余额不足");
//                    }
//                } finally {
//                    lock.unlock(); // 释放锁
//                }
//            }
//        }



    }
}

