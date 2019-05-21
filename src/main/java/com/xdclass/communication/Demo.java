package com.xdclass.communication;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Demo {

    private static  volatile  boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (!flag) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }
          System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag = true; //什么时候 把flag改为true我们并不知道
        }).start();
    }

}
