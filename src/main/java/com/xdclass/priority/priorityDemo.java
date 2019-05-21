package com.xdclass.priority;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class priorityDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        },"线程1");
        Thread t2 = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        },"线程2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
