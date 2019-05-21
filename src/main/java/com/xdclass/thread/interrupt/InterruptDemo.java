package com.xdclass.thread.interrupt;

import static java.lang.Thread.sleep;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class InterruptDemo implements Runnable {

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemo());
        t1.start();
        Thread.sleep(3000L);
        t1.interrupt();//标记线程为准备结束
    }
}
