package com.xdclass.lock.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author
 * @description自定义锁  java.lang.IllegalMonitorStateException
 * @date 2019/5/8
 */
public class MyLock implements Lock {

    private static boolean isHoldLock= false;
    //用于保存持有锁的那个线程
    private Thread holdLockThread = null;
    //重入次数
    private int reentryCount = 0;
    @Override
    public synchronized  void lock() {
        //判断是否持有锁 并且 当前线程不是持有锁的线程（就是一个新的线程进来了 才会挂起 持有锁的线程再次进来是不需要挂起的）
        if(isHoldLock && Thread.currentThread()!= holdLockThread){
            try {
                wait(); //再有线程进来 首先判断一下 是否有锁 有锁就让他挂起等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        reentryCount++;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        //随机唤起一个线程进入代码块
        ///判断当前线程是否是持有锁的线程，是，重入次数减去1，不是就不做处理 持有锁的线程才会被唤醒
        if(Thread.currentThread()==holdLockThread){
            reentryCount--;
            if(reentryCount==0){
                notify();
                isHoldLock = false;
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
