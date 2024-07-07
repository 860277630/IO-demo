package com.example.gupao.Bio.demo6326;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 18:07
 **/
public class BufferedDemo {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(new FileInputStream("E:/test.txt"));
            //默认是8kb
            BufferedOutputStream bufferedOutputStream =
                    new BufferedOutputStream(new FileOutputStream("E:/txt.txt"));
            int len = 0;
            byte[] bys = new byte[1024];
            while((len = bufferedInputStream.read(bys))!=-1){
                System.out.println(new String (bys,0,len));
                bufferedOutputStream.write(bys,0,len);
                bufferedOutputStream.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
