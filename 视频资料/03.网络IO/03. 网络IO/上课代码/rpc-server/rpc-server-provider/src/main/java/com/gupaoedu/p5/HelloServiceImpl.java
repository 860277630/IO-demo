package com.gupaoedu.p5;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/16-18:04
 */
@GpRemoteService
public class HelloServiceImpl implements IHelloService{

    @Override
    public String sayHello(String name) {
        return "Hello Gays~ :"+name;
    }

    @Override
    public String saveUser(User user) {
        return "Save User Success"+user;
    }

    @Override
    public String queryUser() {
        return "Return Some User";
    }
}
