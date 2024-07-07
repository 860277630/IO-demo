package com.example.gupao.Io;

import java.io.FileInputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 23:46
 **/
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("E:/test.txt");
            int i = 0;
            while((i=fileInputStream.read())!=-1){
                System.out.print((char)i);//ASCII码
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
