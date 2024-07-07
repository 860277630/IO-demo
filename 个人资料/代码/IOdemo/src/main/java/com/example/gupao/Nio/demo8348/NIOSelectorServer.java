package com.example.gupao.Nio.demo8348;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 21:01
 **/
public class NIOSelectorServer {
    static Selector selector; //多路复用器
    public static void main(String[] args) {
        try {
            selector = Selector.open();  // 创建一个多路复用器
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(Boolean.FALSE);//这个必须要设置为非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            // 监听连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();//  阻塞
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();// 避免重复处理
                    //selectionKey.isConnectable();  经过三次握手 变为可连接状态
                    //selectionKey.isAcceptable();   在可连接的基础上  做好缓冲池等准备工作  变为数据传输就绪状态
                    //selectionKey.isReadable();     可读状态
                    //selectionKey.isWritable();     可写状态
                    if(selectionKey.isAcceptable()){// 连接事件
                        handleAccept(selectionKey);
                    }else if(selectionKey.isReadable()){ //读事件
                        handleRead(selectionKey);
                    }

                }
            }
        }catch (Exception e){e.printStackTrace();}
    }

    private static void handleAccept(SelectionKey selectionKey) throws Exception{
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        //是不是一定存在客户端连接过来，这里一定不会返回空
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(Boolean.FALSE);  // 设置的IO的非阻塞
        socketChannel.write(ByteBuffer.wrap("Hello Clienit,I'm NIO Server With Selector".getBytes()));
        //这里注册的是 SocketChannel的读事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws Exception{
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("server recevice Msg:"+new String (byteBuffer.array()));
    }
}
