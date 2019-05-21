package com.xdclass.demo4;

import java.io.*;

/**
 * @author
 * @description
 * @date 2019/5/9
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
//把控制台的字节流
        pipedOutputStream.connect(pipedInputStream);
        new  Thread(new Reader(pipedInputStream)).start();
//从控制台写入数据给管道
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pipedOutputStream.close();
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }
    }
}
