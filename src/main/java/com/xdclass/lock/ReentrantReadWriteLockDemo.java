package com.xdclass.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author
 * @description
 *
 * @date 2019/5/8
 */
public class ReentrantReadWriteLockDemo {

    private int i=0;
    private int j=0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    public void out(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" i的值===》"+i+" j的值====》"+j);
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public void inCreate(){
        writeLock.lock();
        //写写互斥
        //
        //读读共享
        try {
            i++;
            Thread.sleep(500L);
            j++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
       /* for (int i=0;i<3;i++){
            new Thread(()->{
              reentrantReadWriteLockDemo.inCreate();
              reentrantReadWriteLockDemo.out();
            }).start();
        }*/
//读写互斥
      /* new Thread(()->{
            reentrantReadWriteLockDemo.out();
       },"读线程").start();
       new Thread(()->{
           reentrantReadWriteLockDemo.inCreate();
       },"写线程").start();*/
// 读读共享
        new Thread(()->{
            reentrantReadWriteLockDemo.out();
        },"读线程1").start();
        new Thread(()->{
            reentrantReadWriteLockDemo.out();
        },"读线程2").start();

    }
}
