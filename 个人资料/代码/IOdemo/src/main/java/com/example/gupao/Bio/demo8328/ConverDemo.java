package com.example.gupao.Bio.demo8328;

import java.io.*;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 19:46
 **/
public class ConverDemo {
    public static void main(String[] args) {
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("E:/mic.txt"))){
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());// 读取一行数据
            //  字符转换流
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(new FileOutputStream("E:/mic_cp.txt"), "gbk");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("你好，咕泡");
            bufferedWriter.flush();
/*            int i = 0;
            char[] by = new char[1024];
            while((i=bufferedReader(by))!=-1){
                System.out.println(new String(by,0,i));
            }*/
        }catch (Exception e){e.printStackTrace();}
    }
}
