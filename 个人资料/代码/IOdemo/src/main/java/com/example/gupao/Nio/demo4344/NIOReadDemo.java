package com.example.gupao.Nio.demo4344;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 16:03
 **/
public class NIOReadDemo {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("E:/test.txt")){
            //Channel
            //针对本地磁盘的文件进行操作
            FileChannel fileChannel = fileInputStream.getChannel();
            // 读取数据，分配缓冲区的大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
/*            byte[] bytes = new byte[1024];
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);*/
            int rs = fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
            /* if(rs==-1)
            *
            *
            * */

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
