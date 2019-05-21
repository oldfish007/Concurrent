package com.xdclass.thread.demo;

import java.io.IOException;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread  thread = new Thread(new MyRunable());
        thread.setName("oldfish");
        //thread.start();
        thread.run();
    }
}
