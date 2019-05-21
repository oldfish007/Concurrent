package com.xdclass.demo3;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Medium {

    //中间商的动态库存
    private int num=0;
    private static final int TOTAL=20;

    /**
     * 接收生产数据
     */
     public synchronized  void put(){
         //判断当前的库存，是否已经是最大的库存容量
         if(num<TOTAL){
         //如果不是，生产完成之后，通知消费者进行消费
             System.out.println("新增库存-------->当前库存"+ ++num);
             try {
                 Thread.sleep(500L);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             notifyAll();
         }else{
         //如果是，则通知生产者进行等待（库存超出容量 就通知生产者暂停生产）
             try {
                  System.out.println("新增库存--------->库存已满"+num);
                  wait();//通知生产等待
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }



     }

    /**
     * 接收消费数据
     */
    public synchronized  void take(){
    //判断当前库存是否>0
         if(num>0){
             System.out.println("消费库存-----------> 当前库存容量"+ --num);
             try {
                 Thread.sleep(1000L);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             //消费了中间商库存 就要通知生产继续生产
             notifyAll();
         }else {
           //中间商库存不足 通知消费者暂停消费
             System.out.println("消费库存-----------> 库存不足"+num);
             try {
                  wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }

}
