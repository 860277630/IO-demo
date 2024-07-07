package com.example.gupao.Bio.demo5325;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 17:54
 **/
public class MemoryDemo {
    static String str = "hello world";
    public static void main(String[] args) {
        // 从内存中 读取数据
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(str.getBytes());
        // 写出到内存中
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int i = 0;
        while((i= inputStream.read())!=-1){
            char c = (char)i;
            outputStream.write(Character.toUpperCase(c));
        }
        System.out.println(outputStream.toString());
    }
}
