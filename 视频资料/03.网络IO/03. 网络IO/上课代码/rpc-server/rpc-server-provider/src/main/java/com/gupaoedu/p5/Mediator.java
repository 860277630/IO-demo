package com.gupaoedu.p5;

import javax.print.attribute.standard.Media;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class Mediator {
    public static Map<String,BeanMethod> beanMethodMap=new ConcurrentHashMap<>();

    private volatile static Mediator instance=null;

    private Mediator(){
    }

    public static Mediator getInstance(){
        if(instance==null){
            synchronized (Mediator.class){
                if(instance==null){
                    instance=new Mediator();
                }
            }
        }
        return instance;
    }
    public Object processor(RpcRequest rpcRequest){
        String key=rpcRequest.getClassName()+"."+rpcRequest.getMethodName();
        BeanMethod beanMethod=beanMethodMap.get(key);
        if(beanMethod==null){
            return null;
        }
        Object bean=beanMethod.getBean();
        Method method=beanMethod.getMethod();
        try {
            return method.invoke(bean,rpcRequest.getParameters());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
