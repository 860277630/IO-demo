package com.example.gupao.Nio.demo4344;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 16:25
 **/
public class NIOReadAndWriteDemo {
    public static void main(String[] args) {
        try{
            FileInputStream fin = new FileInputStream("E:/test.txt");
            FileOutputStream fout = new FileOutputStream("E:/test_cp.txt");
            FileChannel fcin = fin.getChannel();
            FileChannel fcout = fout.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            while(true){
                System.out.println("come in");
                int r = fcin.read(byteBuffer);
                if(r == -1){break;}
                // 每读到 10个字节 ，写入缓冲区
                byteBuffer.flip();
                fcout.write(byteBuffer);
                byteBuffer.clear();//清空
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
