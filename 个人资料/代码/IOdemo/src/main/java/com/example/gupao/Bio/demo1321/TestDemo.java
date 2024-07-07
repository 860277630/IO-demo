package com.example.gupao.Bio.demo1321;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 14:51
 **/
public class TestDemo {
    public static void main(String[] args) throws Exception{
        //磁盘IO
/*        try {
            FileInputStream inputStream = new FileInputStream("E:/test.txt");
        }catch (Exception e){
            e.printStackTrace();
        }*/
        //内存
        String str = "hello world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        int i = 0;
        while((i=byteArrayInputStream.read())!=-1){
            System.out.println((char)i);
        }
        // 键盘
        // Scanner
/*        InputStream inputStream = System.in;
        int i = 0;
        while((i=inputStream.read())!=-1){
            System.out.println((char)i);
        }*/
    }
}
