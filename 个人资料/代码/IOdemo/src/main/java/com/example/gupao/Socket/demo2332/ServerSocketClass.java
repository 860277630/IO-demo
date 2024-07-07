package com.example.gupao.Socket.demo2332;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 21:25
 **/
public class ServerSocketClass {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            Socket socket  = serverSocket.accept();
            System.out.println("客户端："+socket.getPort()+"已连接");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientStr = bufferedReader.readLine();
            System.out.println("收到客户端的请求信息："+clientStr);
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("服务端返回消息：收到了你的消息" + clientStr + "\n");
            bufferedWriter.flush(); //清空缓冲区

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
