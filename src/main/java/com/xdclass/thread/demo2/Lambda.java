package com.xdclass.thread.demo2;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

}
