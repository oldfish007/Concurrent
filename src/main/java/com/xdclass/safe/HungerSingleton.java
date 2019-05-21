package com.xdclass.safe;

/**
 * @author
 * @description 饿汉式 是线程安全的
 * @date 2019/5/8
 */
public class HungerSingleton {

    private static  HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton(){}
    private static HungerSingleton getInstance(){
        return hungerSingleton;
    }

    public static void main(String[] args) {
            for (int i=0;i<10;i++){
                new Thread(()->{
                    System.out.println(HungerSingleton.getInstance());
                }).start();
            }
    }
}
