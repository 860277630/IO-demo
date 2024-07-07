package com.example.gupao.Bio.demo2322;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 15:05
 **/
public class FileDemo {
    //根据用户端输入的路径进行目录的遍历
    public static void main(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String path = bufferedReader.readLine(); //读取用户输入的路径
            File file = new File(path);
            if(file.isDirectory()&&file.exists()){
                //去遍历这个目录下的所有子目录
                fileList(file);
            }else {
                System.out.println("文件路径输入错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            reader.close();
        }
    }

    private static void fileList(File filePath){
        File[] files = filePath.listFiles();
        if(files!=null){
            for (int i = 0; i < files.length; i++) {
                if(files[i].isFile()){
                    System.out.println(files[i].getName());// 输出具体的文件名
                }else{
                    // 如果是一个目录
                    fileList(files[i]);//  递归遍历
                }
            }
        }

    }
}
