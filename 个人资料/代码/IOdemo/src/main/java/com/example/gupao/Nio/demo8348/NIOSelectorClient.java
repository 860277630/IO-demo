package com.example.gupao.Nio.demo8348;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 22:45
 **/
public class NIOSelectorClient {
    static Selector selector;

    public static void main(String[] args) {
        try{
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(Boolean.FALSE);
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while(true){
                selector.select();//  阻塞
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();  //  避免重复处理
                    //key.isConnectable();    经过三次握手 变为可连接状态
                    //key.isAcceptable();     在可连接的基础上  做好缓冲池等准备工作  变为数据传输就绪状态
                    //key.isReadable();       可读状态
                    //key.isWritable();       可写状态
                    if(key.isConnectable()){
                        handleConnect(key);
                    }else {
                        handleRead(key);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void wakeup(){
        selector.wakeup();
    }

    private static void handleConnect(SelectionKey key)throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        if(socketChannel.isConnectionPending()){
            socketChannel.finishConnect();
        }
        socketChannel.configureBlocking(Boolean.FALSE);
        socketChannel.write(ByteBuffer.wrap("Hello Server,I'm NIO Client".getBytes()));
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key)throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("client receive msg"+new String(byteBuffer.array()));
    }
}
