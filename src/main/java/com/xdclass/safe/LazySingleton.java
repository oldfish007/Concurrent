package com.xdclass.safe;

/**
 * @author
 * @description 单例 懒汉式 是非线程安全的
 * @date 2019/5/8
 */
public class LazySingleton {

    private static LazySingleton lazySingleton  =null;

    private LazySingleton(){}
    private static/* synchronized */ LazySingleton getInstance(){
        if(null == lazySingleton){
            //模拟耗时操作
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingleton.class){
                System.out.println(Thread.currentThread().getName()+"进来了");
                if(null==lazySingleton){
                System.out.println(Thread.currentThread().getName()+"进来了准备创建");
                lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(LazySingleton.getInstance());
            },"线程"+i).start();
        }
    }
}
