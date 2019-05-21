package com.xdclass.thread.demo2;

/**
 * @author
 * @description匿名方式
 * @date 2019/5/7
 */
public class MyThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.setName("匿名线程");
        thread.start();
    }
}
