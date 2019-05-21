package com.xdclass.demo2;

/**
 * @author
 * @description 中间商
 * @date 2019/5/9
 */
public class Medium {

    private int num=0;//中间商的库存
    private static final int TOTAL=20; //当前的最大容量 常量

    /**
     * 获取生产数据
     */
    public synchronized void put(){

        //判断当前库存是否已经是当前最大的容量
        if(num<TOTAL){
        //如果不是 生产完成之后 通知消费者进行消费
            System.out.println("新增库存------->当前库存"+ ++num);
            notifyAll();
        }else{
        //如果是，则通知生产者进行等待（先不要继续生产了）
            System.out.println("新增库存-------->当前库存已满"+num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 获取消费数据
     */
    public synchronized  void take(){
        // 判断当前库存是否不足
        if(num>0){
        //如果充足！在消费完成之后通知生产者进行生产
            System.out.println("消费库存------------>当前库存容量"+ --num);
            //除了要消费库存还要通知厂家生产
            //在这之前生产者有可能进入了一个wait的状态
            notifyAll();
        }else {
        //如果库存不足，通知消费这暂停消费
            System.out.println("消费库存------------->库存不足"+num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
