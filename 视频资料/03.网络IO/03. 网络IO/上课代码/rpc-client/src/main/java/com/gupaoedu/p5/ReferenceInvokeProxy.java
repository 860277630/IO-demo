package com.gupaoedu.p5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Component
public class ReferenceInvokeProxy implements BeanPostProcessor{
    @Autowired
    RemoteInovcationHandler inovcationHandler;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields=bean.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(GpReference.class)){
                field.setAccessible(true);
                //针对带有GpReference的注解的字段，增加动态代理的实现
                Object proxy=Proxy.newProxyInstance(field.getType().getClassLoader(),
                        new Class<?>[]{field.getType()},inovcationHandler);
                try {
                    field.set(bean,proxy); //赋值
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
