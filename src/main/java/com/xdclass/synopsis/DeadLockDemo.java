package com.xdclass.synopsis;

/**
 * @author
 * @description 死锁demo
 * 我在想抓对方头发时护住自己的头发，抓对方的头发
 * 对方想抓我的头发 护住自己的头发
 * @date 2019/5/6
 */
public class DeadLockDemo {

    private static final Object HAIR_A = new Object();
    private static final  Object HAIR_B = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (HAIR_A){//护住自己的头发
                try {
                    Thread.sleep(50L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (HAIR_B){ //获取到对方头发的时候进行一个简单的输出
                    System.out.println("A成功的抓住B的头发");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (HAIR_B){//B护住自己的头发
                synchronized (HAIR_A){
                    System.out.println("B成功的抓住了A的头发");
                }
            }
        }).start();

    }
}
/**
 * A成功的抓住B的头发
 * B成功的抓住了A的头发
 */
