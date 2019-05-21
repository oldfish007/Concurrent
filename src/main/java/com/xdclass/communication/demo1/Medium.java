package com.xdclass.communication.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 中间商
 * @author
 * @description
 * @date 2019/5/21
 */
public class Medium {

    private int num=0;
    private static final int TOTAL=20;

    private Lock lock = new ReentrantLock();
    private Condition consumerCondition = lock.newCondition();
    private Condition producerCondition = lock.newCondition();

    /**
     * 厂家生产数据
     */
    public  void put(){

        lock.lock();
        try{
            //判断当前的库存，是否已经是最大的库存容量
            if(num<TOTAL){
                System.out.println("新增库存-------->当前库存"+ ++num);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //唤起挂起的消费者
               // notifyAll();//唤醒所有挂起的线程
                consumerCondition.signalAll();
            }else{
                //否则 停止生产 生产者挂起
                try{
                    System.out.println("新增库存---------> 中间商库存已满"+num);
                    //wait();//生产着挂起
                    producerCondition.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }

    }

    /**
     * 消费者消费数据
     */
    public  void take(){
        lock.lock();
        try{
            //判断当前库存是否不足
            if(num>0){
                //如果充足，在消费完成之后通知生产者进行生产
                System.out.println("消费库存-----------> 当前库存容量" + --num);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //notifyAll();
                //消费以后通知厂家继续生产
                producerCondition.signalAll();
            }else{
                //如果不足，通知消费者暂停消费
                try{
                    //wait();
                System.out.println("消费库存-----------> 库存不足"+num);
                    consumerCondition.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }



    }
}
