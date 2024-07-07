package com.example.bio.system;


import java.io.File;

/**
 * @program: IOdemo
 * @description: 读取txt文件
 * @author: wjl
 * @create: 2023-09-19 00:53
 **/
public class ReadTxt {

    public static final String path = "./src/main/resources/files/test.txt";

    public static void main(String[] args) {
        File file = new File(path);
        System.out.println(file.exists());
    }
}
