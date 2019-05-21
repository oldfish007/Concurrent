package com.xdclass.thread.interrupt;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class MyInterruptDemo implements Runnable {

    private static volatile boolean FLAG=true;
    @Override
    public void run() {
        while(FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyInterruptDemo());
        t1.start();
        Thread.sleep(1000L);
        FLAG=false;
    }
}
