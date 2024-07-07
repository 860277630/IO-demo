package com.example.bio.socket;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-08-29 17:18
 **/
public class BioThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("BioServer listening on port:"+serverSocket.getLocalSocketAddress());
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from"+clientSocket.getRemoteSocketAddress());
                executorService.submit(()->{
                    try(Scanner input = new Scanner(clientSocket.getInputStream())){
                        while(true){
                            String request = input.nextLine();
                            if("quit".equals(request)){break;}
                            System.out.println("From client request:"+request+"  clientSocket:"+clientSocket.getPort());
                            String response = "From Server response:"+request+"  clientSocket:"+clientSocket.getPort()+" ok. \r\n\r\n";
                            OutputStream output = clientSocket.getOutputStream();
                            output.write(response.getBytes());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
