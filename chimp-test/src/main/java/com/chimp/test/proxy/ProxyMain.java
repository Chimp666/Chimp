package com.chimp.test.proxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @auther: liux
 * @date: 2019/6/13 17:18
 * @description: TODO
 */
public class ProxyMain {

    public static void main(String args[]){
//        LogInvocationHandler handler = new LogInvocationHandler(new HelloImp());
//        Hello hello = handler.newProxyInstance();
////        System.out.println(hello.sayHello("I love you!"));

        HelloProxyFactory proxyFactory = new HelloProxyFactory(new HelloImp());
        Hello hello = (Hello) proxyFactory.getProxyInstance();

        System.out.println(hello.saySorry("I love you!"));
    }

}
