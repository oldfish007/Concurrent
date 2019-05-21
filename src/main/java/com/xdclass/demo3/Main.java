package com.xdclass.demo3;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Main {
    public static void main(String[] args) {
        Medium medium = new Medium();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();


        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
    }
}
