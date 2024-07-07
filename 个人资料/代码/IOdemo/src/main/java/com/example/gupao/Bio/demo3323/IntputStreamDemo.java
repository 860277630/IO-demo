package com.example.gupao.Bio.demo3323;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 15:25
 **/
public class IntputStreamDemo {

    // I input  从磁盘读取数据到内存
    // O output 把内存中的数据写入到磁盘
    public static void main(String[] args) throws Exception{
        File file = new File("E:/logo.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream("E:/logo_cp.png");
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len=fileInputStream.read())!=-1){
            // 读取的数据可以保存在内存中
            // 也可以写出到磁盘
            //fileOutputStream.write(len); //写到磁盘（10000次的磁盘交互）
            fileOutputStream.write(buffer,0,len); // 把InputStream的输入字节写出到指定的目录下
        }
        fileOutputStream.close();
        fileInputStream.close();

    }
}
