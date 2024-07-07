package com.example.person;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
            FileInputStream inputStream = new FileInputStream("D://6.zip");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            System.out.println(bytes.length);
            outputStream.write("Hello Mic".getBytes("UTF-8"));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
