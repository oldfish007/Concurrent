package com.xdclass.thread.interrupt;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class UnsafeWithStop extends Thread {

    private int i= 0;
    private int j= 0;
    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }
    public void printf(){
        System.out.println("i的值=======》"+i);
        System.out.println("j的值=======》"+j);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeWithStop unsafeWithStop = new UnsafeWithStop();
        unsafeWithStop.start();
        Thread.sleep(1000L);
        //此处当子线程start的时候 i++ 休眠2S 休眠到1S的时候主线程醒了 随后直接stop 那么j++ 就没有执行到所以输出i=1 j=0
        //导致线程安全问题 一般不要使用stop 因为一调用线程就立刻停止
        unsafeWithStop.stop();
        unsafeWithStop.printf();
    }
}
