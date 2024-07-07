package com.example.gupao.Nio.demo7347;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 17:48
 **/
public class NIOSocketServer01 {
    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(
                    new InetSocketAddress(8080));
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();//仍然是阻塞
                // 如果代码进入这个位置 ，说明有连接过来
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                System.out.println(new String(buffer.array()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
