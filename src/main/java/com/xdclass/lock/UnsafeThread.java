package com.xdclass.lock;

import com.xdclass.lock.mylock.MyLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
/**
 * @author
 * @description  java.lang.IllegalMonitorStateException
 * @date 2019/5/8
 */
public class UnsafeThread {
    private  static int num=0;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

  //  private static  Lock lock = new ReentrantLock();\
    //使用自定义锁
    private static Lock  lock = new MyLock();
    //非原子性操作
    public static void inCreate(){
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<100;j++){//10个线程 每个线程自增100次
                inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完成之后，调用countDownLatch
                countDownLatch.countDown();
            }).start();
        }

        while (true) {
            if (countDownLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }
    }


}
