package com.example.bio.socket;

import javax.lang.model.element.VariableElement;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-08-29 16:41
 **/
public class BioDemo {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("BioServer listening on port:"+serverSocket.getLocalSocketAddress());
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from"+clientSocket.getRemoteSocketAddress());
                try(Scanner input = new Scanner(clientSocket.getInputStream())){
                    while(true){
                        String request = input.nextLine();
                        if("quit".equals(request)){break;}
                        System.out.println("From client request:"+request);
                        String response = "From Server response:"+request+" ok. \r\n\r\n";
                        OutputStream output = clientSocket.getOutputStream();
                        output.write(response.getBytes());
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
