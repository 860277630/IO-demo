package com.example.gupao.Bio.demo8328;

import java.io.FileInputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 19:25
 **/
public class ByteReadDemo {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("")){
            int len = 0;
            byte[] bf = new byte[1024];
            while((len =fileInputStream.read(bf))!=-1){
                System.out.println(new String(bf,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
