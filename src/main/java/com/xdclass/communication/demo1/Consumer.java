package com.xdclass.communication.demo1;

/**
 * @author
 * @description
 * @date 2019/5/21
 */
public class Consumer implements Runnable{

    private Medium medium;
    public Consumer(Medium medium){
        this.medium = medium;
    }


    @Override
    public void run() {
        while (true) {
            medium.take();
        }
    }
}
