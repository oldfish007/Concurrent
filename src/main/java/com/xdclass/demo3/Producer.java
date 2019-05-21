package com.xdclass.demo3;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Producer implements Runnable{

    private Medium medium;

    public Producer(Medium medium){
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            //不停的生产
            medium.put();
        }
    }
}
