package com.gupaoedu.p5;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan("com.gupaoedu.p5")
public class App implements BeanPostProcessor
{

    public static void main( String[] args ){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(App.class);

        /*IHelloService service=new HelloServiceImpl();
        RpcProxyServer proxyServer=new RpcProxyServer();
        proxyServer.publisher(service,8888);
        System.out.println( "Hello World!" );*/
    }
}
