package com.xdclass.thread.demo2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @description
 * @date 2019/5/7
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());//pool-1-thread-1
        });

    }
}
