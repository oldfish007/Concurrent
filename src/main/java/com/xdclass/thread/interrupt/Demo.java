package com.xdclass.thread.interrupt;
/**
 * @author
 * @description中断操作
 * @date 2019/5/7
 */
public class Demo implements Runnable{

  @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException {
        Thread t1 = new Thread(new Demo());
        t1.start();
        Thread.sleep(2000L);
        t1.stop();//这个stop有什么问题呢 他在停止的时候释放一些所持有的一些锁
        //这就有可能会导致线程安全性的一些问题
    }

}
