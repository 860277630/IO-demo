package com.example.gupao.Nio.demo4344;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 16:15
 **/
public class NIOWriteDemo {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("E:/nio-demo.txt")){
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //往byteBuffer写数据
            byteBuffer.put("Hello,I'm NIO Program".getBytes());//往缓冲区写数据
            byteBuffer.flip(); //把读模式转化为写模式
            fileChannel.write(byteBuffer);// 读取byteBuffer的数据

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
