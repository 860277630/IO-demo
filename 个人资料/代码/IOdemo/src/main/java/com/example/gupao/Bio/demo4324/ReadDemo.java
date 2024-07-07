package com.example.gupao.Bio.demo4324;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 15:49
 **/
public class ReadDemo {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("E:/test.txt")){
            int i = 0;
            byte[] buffer = new byte[1024*1024];// 占用内存空间

            while((i=fileInputStream.read(buffer))!=-1){
                System.out.println(new String (buffer,0,i));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
