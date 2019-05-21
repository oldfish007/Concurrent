package com.xdclass.demo5;

/**
 * @author
 * @description
 * @date 2019/5/9
 *
 * Thread-0----------->1
 * Thread-1----------->1
 * Thread-0----------->2
 * Thread-0----------->3
 * Thread-1----------->2
 * Thread-0----------->4
 * Thread-1----------->3
 * Thread-0----------->5
 * Thread-0----------->6
 */
public class ThreadLocalDemo {
    //初始化threadLocal 变量
    private ThreadLocal<Integer> num = ThreadLocal.withInitial(()->0);
    /**
     * 自增并输出num的值
     */
    public void inCreate(){
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "----------->" + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i=1;i<3;i++){
            int finalI = i;
            new Thread(()->{
                while (true){
                    threadLocalDemo.inCreate();
                    try {
                        Thread.sleep(finalI *1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
