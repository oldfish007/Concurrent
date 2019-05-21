package com.xdclass.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description
 * @date 2019/5/8
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
