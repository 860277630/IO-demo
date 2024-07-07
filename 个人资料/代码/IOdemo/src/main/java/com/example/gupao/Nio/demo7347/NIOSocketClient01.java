package com.example.gupao.Nio.demo7347;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 19:19
 **/
public class NIOSocketClient01 {
    public static void main(String[] args) {
        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(
                    new InetSocketAddress("localhost",8080));
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello,I'm SocketChannel Client01".getBytes());
            byteBuffer.flip(); //由读模式转为写模式
            socketChannel.write(byteBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
