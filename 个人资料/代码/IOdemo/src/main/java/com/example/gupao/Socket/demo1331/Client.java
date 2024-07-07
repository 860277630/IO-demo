package com.example.gupao.Socket.demo1331;

import java.io.*;
import java.net.Socket;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-04 17:25
 **/
public class Client {
    public static void main(String[] args) {
        try {
            //会向指定的ip和端口发起一个远程连接操作
            Socket socket=new Socket("localhost",8080);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello Mic".getBytes("UTF-8"));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
