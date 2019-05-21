package com.xdclass.lock;

import com.xdclass.lock.mylock.MyLock;

import java.util.concurrent.locks.Lock;

/**
 * @author
 * @description不可重入锁
 * @date 2019/5/8
 */
public class ReentryDemo {

    public Lock lock = new MyLock();

    public void methodA(){
        lock.lock();
        System.out.println("A方法进入了");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("B方法进入了");
        lock.unlock();
    }
//方法A进入就被挂起了 因为在此进入methodB 的时候由于isHoldLocK 已经为true了所以进入以后就为wait状态
    public static void main(String[] args) {
        ReentryDemo reentryDemo = new ReentryDemo();
        reentryDemo.methodA();
    }
}
