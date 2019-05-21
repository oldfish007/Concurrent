package com.xdclass.thread;
/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        /* RUNNABLE状态
        Thread thread = new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();*/
        //BLOCKD
        //这个状态是在等待synchronized就会进入blocked状态
       /* Object obj = new Object();
        Thread thread = new Thread(()->{
           synchronized (obj) {
                try {
                   Thread.sleep(100000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
       });
        thread.start();

        Thread.sleep(2000L);//主线程休眠一小段时间
//跟着启动另外一个线程
        Thread thread2 = new Thread(()->{
            synchronized (obj){ //这个线程就去获取这把锁

            }
        });
        thread2.start();*/

        Object obj = new Object();
        Thread thread = new Thread(()->{
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


    }

}
