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
public class NIOSocketClient02 {
    public static void main(String[] args) {
        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(Boolean.FALSE);
            // 在非阻塞模式下，这段代码并不一定是等到链接建立之后再往下执行
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            if(socketChannel.isConnectionPending()){
                socketChannel.finishConnect();
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello,I'm SocketChannel Client01".getBytes());
            byteBuffer.flip(); //由读模式转为写模式
            socketChannel.write(byteBuffer);

            // 读取服务端返回的数据
            byteBuffer.clear();
            int r =  socketChannel.read(byteBuffer);// 非阻塞模式，这里不阻塞
            if(r>0){
                System.out.println("收到服务端的消息："+new String(byteBuffer.array()));
            }else{
                System.out.println("服务端的数据还未返回");
            }
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
