package com.chimp.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @auther: liux
 * @date: 2019/6/13 16:14
 * @description: TODO
 */
class LogInvocationHandler implements InvocationHandler {

    private Hello hello;

    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------before------------");
        if ("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
        }
        Object object = method.invoke(hello, args);
        System.out.println("-------------after------------");
        return object;
    }

    public Hello newProxyInstance() {
        return (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), // 1. 类加载器
                hello.getClass().getInterfaces(), // 2. 代理需要实现的接口，可以有多个
                this);// 3. 方法调用的实际处理者
    }

}