package com.gupaoedu.pratice.day01;

import java.io.*;
import java.net.Socket;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-20:32
 */
public class ClientSocketDemo1 {

    public static void main(String[] args) {
        try {
            //会向指定的ip和端口发起一个远程连接操作
            Socket socket=new Socket("localhost",8080);
            Thread.sleep(10000);
            BufferedWriter bufferedWriter=new BufferedWriter
                    (new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端Client-02\n");
            bufferedWriter.flush(); //清空缓冲区

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverStr=bufferedReader.readLine();
            System.out.println("收到服务端的消息："+serverStr);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
