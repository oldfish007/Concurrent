package com.xdclass.demo2;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Consumer  implements  Runnable{

    private Medium medium;

    public Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        //不断的取别人的数据
        while(true){
            medium.take();
        }
    }
}
