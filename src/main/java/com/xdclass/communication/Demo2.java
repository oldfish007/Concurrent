package com.xdclass.communication;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Demo2 {

    private static volatile  boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        new Thread(()->{
            while(!flag){
                synchronized (obj){
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true");
        }).start();

        new Thread(()->{
            while(!flag){
                synchronized (obj){
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag=true;
            synchronized (obj){
                obj.notifyAll();
            }
        }).start();
    }


}
