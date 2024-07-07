package com.example.person;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-04 17:25
 **/
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = inputStream.read(buff))!=-1){
                System.out.println(new String(buff,0,len,"UTF-8"));
            }
            inputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
