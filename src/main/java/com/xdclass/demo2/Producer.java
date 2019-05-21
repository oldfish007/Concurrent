package com.xdclass.demo2;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public  class Producer implements Runnable{


    private Medium medium;

    public Producer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        //不停的生产数据 一直往中间商里面去put
        while (true){
            medium.put();
        }
    }


}
