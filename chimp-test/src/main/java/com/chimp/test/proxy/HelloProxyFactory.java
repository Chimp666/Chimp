package com.chimp.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @auther: liux
 * @date: 2019/6/13 17:58
 * @description: TODO
 */
public class HelloProxyFactory {

    private Hello hello;

    public HelloProxyFactory(Hello hello) {
        this.hello = hello;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("-------------before------------");
            // 执行目标对象方法
            Object returnValue = method.invoke(hello, args);
            System.out.println("-------------after------------");
            return returnValue;
        });
    }

}
