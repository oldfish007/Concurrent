package com.xdclass.thread;

import java.io.IOException;

/**
 * @author
 * @description
 * @date 2019/5/6
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        System.out.println("123");
        System.in.read();//让程序阻塞住
    }

}
