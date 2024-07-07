package com.example.gupao.Bio.demo9329;

import javax.lang.model.element.VariableElement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 21:01
 **/
public class ObjectDemo {
    public static void main(String[] args) {
        //实现对象的序列化
/*        User user = new User("Mic", 18);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("E:/user"))){
            outputStream.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        // 反序列化
/*        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream("E:/user"))){
            User us = (User) objectInputStream.readObject();
            System.out.println("result"+us);
        }catch (Exception e){
            e.printStackTrace();
        }*/



    }
}
