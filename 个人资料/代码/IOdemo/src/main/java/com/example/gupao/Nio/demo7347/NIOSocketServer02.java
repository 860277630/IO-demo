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
public class NIOSocketServer02 {
    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(Boolean.FALSE);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            while(true){
                //此处不再阻塞
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel!=null){
                    // 如果代码进入这个位置 ，说明有连接过来
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    System.out.println(new String(buffer.array()));

                    //再把消息写回到客户端
                    Thread.sleep(10000);
                    //buffer.flip();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("Hello I'm Server Channel".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    //socketChannel.write(buffer);
                }else{
                    Thread.sleep(1000);
                    System.out.println("没有客户端连接过来");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
