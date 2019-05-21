package com.xdclass.demo5;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class TestJoin {

    public static void main(String[] args) {
       Thread t1 = new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"开始运行");
           try {
               Thread.sleep(3000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"运行结束");

       },"线程1");

        new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"开始运行");
           t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束运行");
       },"线程2").start();
    }

}
