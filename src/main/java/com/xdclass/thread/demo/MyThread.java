package com.xdclass.thread.demo;

/**
 * @author
 * @description 线程创建上
 * @date 2019/5/7
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("线程demo");
        myThread.start();
    }
}
