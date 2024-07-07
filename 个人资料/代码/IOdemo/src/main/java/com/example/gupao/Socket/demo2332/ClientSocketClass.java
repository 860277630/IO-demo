package com.example.gupao.Socket.demo2332;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 21:37
 **/
public class ClientSocketClass {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        try {
            Socket socket = new Socket("localhost", DEFAULT_PORT);
            BufferedWriter bufferedWriter =
                    new BufferedWriter
                            (new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端发送的消息：client-01\n");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            String serverStr = bufferedReader.readLine();
            System.out.println("收到服务端的消息："+serverStr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
