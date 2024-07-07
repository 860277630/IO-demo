package com.example.gupao.Bio.demo7327;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 19:11
 **/
public class FlushDemo {
    public static void main(String[] args) throws Exception{
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:/mic.txt"));

        bufferedOutputStream.write("Hello world".getBytes());
        //bufferedOutputStream.flush(); // 刷盘动作
        bufferedOutputStream.close(); // close 方法也会触发刷盘操作
    }
}
