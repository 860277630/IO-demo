package com.example.gupao.Bio.demo8328;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 19:36
 **/
public class ReaderWriterDemo {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("E:/mic.txt");
            FileWriter writer = new FileWriter("E:/mic_cp.txt")){
            int i = 0;
            char[] by = new char[1024];
            while((i=reader.read(by))!=-1){
                writer.write(by,0,i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
