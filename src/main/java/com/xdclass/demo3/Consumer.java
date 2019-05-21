package com.xdclass.demo3;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Consumer implements  Runnable{

    private Medium medium;

    public Consumer(Medium medium){
        this.medium = medium;
    }

    @Override
    public void run() {
        while(true){
            //不停的消费
            medium.take();
        }
    }
}
