package com.xdclass.thread.hang;

/**
 * @author
 * @description线程挂起 废弃方法
 * @date 2019/5/7
 */
public class SuspendDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行run方法，准备执行Suspend方法");
        //这里线程挂起 主线程休眠3 线程又回到runable
        Thread.currentThread().suspend();//这个方法如果持有了锁 他不会进行释放的操作
        //拿着这个锁就直接挂起了 这样会引发线程安全性有可能会引发死锁
        System.out.println(Thread.currentThread().getName()+"执行run方法，执行Suspend方法结束");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new SuspendDemo());
        thread.start();
        Thread.sleep(3000L);//如果不休眠刚挂起 就唤醒这个过程很连贯
        thread.resume();//这个方法脱离了suspend 这个方法无法独立去使用
    }
}
