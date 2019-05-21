package com.xdclass.synopsis;

import java.util.concurrent.CountDownLatch;

/**
 * 线程安全
 * @author
 * @description
 * @date 2019/5/6
 */
public class UnSafeThread {

    private static int num=0;
    private static CountDownLatch countDownLatch =  new CountDownLatch(10);
    /**
     * 每次调用对NUM进行++操作
     */
    public static void inCreate(){
        num++;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
              for (int j=0;j<100;j++){
                  inCreate();

                  try {
                    Thread.sleep(10);
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
              }
                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();
        }
        while(true){
            if(countDownLatch.getCount() == 0){
                System.out.println(num);// 每次输出都是九百多 10个线程 每个线程都是加到100 怎么每次输出都不足1000呢？？
                //并发对这个变量访问的时候 导致
                break;
            }
        }

        // System.out.println(num);0 为什么得到的结果会是0呢 10个线程启动完成可能还没调用inCreate() num就输出了
    }
}



