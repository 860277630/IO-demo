package com.example.gupao.Nio.demo9349;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 23:13
 **/
public class ZeroCopyServer {
    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            SocketChannel socketChannel = serverSocketChannel.accept();// 阻塞获得客户端连接
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            int r= 0;
            FileChannel fileChannel = new FileOutputStream("E:/音乐_cp.zip").getChannel();
            while(r!=-1){
                r = socketChannel.read(byteBuffer);
                //TODO
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
