package com.example.gupao.Nio.demo9349;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 23:22
 **/
public class ZeroCopyClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8080));
        FileChannel fileChannel = new FileInputStream("E:/音乐.zip").getChannel();
        // tf 表示总的字节数
        int position = 0;
        long size = fileChannel.size();
        while(size>0){
            long tf = fileChannel.transferTo(position, size, socketChannel);
            if(tf>0){
                position+=tf;
                size-=tf;
            }
        }
        socketChannel.close();
        fileChannel.close();
    }
}
