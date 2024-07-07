package com.example.gupao.Bio.demo6326;

import java.io.*;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 18:25
 **/
public class BufferedCopyDemo {
    public static final File fileSource = new File("E:/音乐.zip");
    public static final File fileTarget = new File("E:/音乐_CP.zip");

    public void copyWithNormal(){
        try (FileInputStream inputStream = new FileInputStream(fileSource);
             FileOutputStream outputStream = new FileOutputStream(fileTarget)){
             byte[] buf = new byte[1024];
             int len = 0;
             while ((len = inputStream.read(buf))!=-1){
                 outputStream.write(buf);
             }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void copyWithBuffered(){
        try (FileInputStream inputStream = new FileInputStream(fileSource);
             FileOutputStream outputStream = new FileOutputStream(fileTarget);
             BufferedInputStream bis = new BufferedInputStream(inputStream);
             BufferedOutputStream bos = new BufferedOutputStream(outputStream)){
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf))!=-1){
                bos.write(buf);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedCopyDemo bcd = new BufferedCopyDemo();
        long start = System.currentTimeMillis();
        bcd.copyWithNormal();
        System.out.println("普通复制耗时："+(System.currentTimeMillis() -start));
        start = System.currentTimeMillis();
        bcd.copyWithBuffered();
        System.out.println("缓冲流复制耗时："+(System.currentTimeMillis() -start));

    }

}
