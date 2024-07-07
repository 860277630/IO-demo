package com.gupaoedu.p5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/16-18:08
 */
public class ProcessorHandler implements Runnable{
    Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;

        try {
            inputStream=new ObjectInputStream(socket.getInputStream());
            //可以拿到那些信息？需要那些信息
            //反序列化
            RpcRequest request=(RpcRequest)inputStream.readObject();
            Mediator mediator=Mediator.getInstance();
            Object result=mediator.processor(request);
//            Object result=inovke(request);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //TODO 关闭流
        }
    }

}
