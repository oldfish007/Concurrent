package com.xdclass.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 多线程debug
 */
public class ReentrantLockDebugDemo {

    private int i = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void inCreate() {
        reentrantLock.lock();
        try {
            i++;
            System.out.println(i);
        } finally {
            reentrantLock.unlock();//释放锁的操作一定要放在finally里面
            //如果不放在finally里面
        }

    }
 public static void main(String[] args) {
        ReentrantLockDebugDemo reentrantLockDebugDemo = new ReentrantLockDebugDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                reentrantLockDebugDemo.inCreate();
            }).start();
        }
    }
}
