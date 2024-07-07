package com.gupaoedu.p5;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IHelloService service=new HelloServiceImpl();
        RpcProxyServer proxyServer=new RpcProxyServer(service,8080);
        new Thread(proxyServer).start();
        System.out.println( "Hello World!" );
    }
}
