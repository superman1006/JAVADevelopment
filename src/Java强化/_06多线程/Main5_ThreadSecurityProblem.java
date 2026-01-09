package Java强化._06多线程;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Main5_ThreadSecurityProblem {
    static void main(String[] args) {
        /**
         * 线程的安全问题
         * 当多个线程同时修改同一个共享数据时，就会出现线程安全问题（互斥）
         * 解决方法：见 Main6_SecuritySolution.java
         */
//      小明和小红一起取钱，取同一个账户
        Account account = new Account("001",1000);
        Thread t1 = new DrawThread("小明",account);
        Thread t2 = new DrawThread("小红",account);

        t1.start();
        t2.start();
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Account{
    private String carId;
    private double money;
    public void draw(double drawMoney){
        String threadName = Thread.currentThread().getName();
        if(this.money>=drawMoney){
            System.out.println(threadName+"取钱成功，已取出：" + drawMoney);
            this.money-=drawMoney;
            System.out.println(threadName+"取钱成功，取出后剩余：" +  this.money);
        }else{
            System.out.println(threadName+"取钱失败，余额不足");
        }
    }
}



class DrawThread extends Thread{
    Account account;
    public DrawThread(String name, Account account) {
        super(name);
        this.account = account;
    }
    @Override
    public void run() {
        // 取钱
        this.account.draw(1000);
    }
}
