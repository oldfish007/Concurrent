package com.xdclass.demo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Reader implements Runnable{

    private PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream){
        this.pipedInputStream = pipedInputStream;
    }
    @Override
    public void run() {
        if(pipedInputStream!=null){
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(Collectors.joining("\n"));
            System.out.println(Thread.currentThread().getName()+ collect);
        }
         try {
             pipedInputStream.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
