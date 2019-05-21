package com.xdclass.thread.hang;

/**
 * @author
 * @description等待线程
 * @date 2019/5/7
 */
public class WaitDemo implements Runnable{
    private static Object obj =  new Object();

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"占用资源");
            try {
                System.out.println("wait方法调用之前");
                obj.wait();//调用wait会释放当前对象所持有的对象锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WaitDemo(),"对比线程");
        t1.start();
        //Thread.sleep(3000L);

        Thread t2 = new Thread(new WaitDemo(),"对比线程2");
        t2.start();
        Thread.sleep(3000L);


        synchronized (obj){
            obj.notify();//随机唤醒一个在等待锁的线程
        }
    }
}
