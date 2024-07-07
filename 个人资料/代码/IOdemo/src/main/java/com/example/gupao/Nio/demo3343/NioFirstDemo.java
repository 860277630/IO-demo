package com.example.gupao.Nio.demo3343;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 15:47
 **/
public class NioFirstDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("E:/test.txt"));
            FileOutputStream fos = new FileOutputStream(new File("E:/test.txt"));

            FileChannel fin = fis.getChannel();
            FileChannel fout = fos.getChannel();
            //初始化一个缓冲区
            ByteBuffer buffer  = ByteBuffer.allocate(1024);
            fin.read(buffer);//读取数据到缓冲区
            buffer.flip();  // 表示从读转化为写
            fout.write(buffer);
            buffer.clear();//重置缓冲区
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
