package com.xdclass.thread.hang;

/**
 * @author
 * @description 这个类我们要做的操作
 * @date 2019/5/7
 */
public class DeadDemo implements  Runnable{

    private static Object object = new Object();
    @Override
    public void run() {
        synchronized (object){//持有资源
            System.out.println(Thread.currentThread().getName()+"占用资源");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+"释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DeadDemo(),"对比线程");
        t1.start();
        Thread.sleep(1000);
        t1.resume();


        Thread t2 = new Thread(new DeadDemo(),"死锁线程");
        t2.start();
        //Thread.sleep(1000);
        t2.resume();//这里程序就阻塞到这里了 因为当线程一启动还没来得及挂起就resume了
    }
}
