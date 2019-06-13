package com.chimp.test.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @auther: liux
 * @date: 2019/6/13 17:37
 * @description: TODO
 */
// CGLIB动态代理
// 1. 首先实现一个MethodInterceptor，方法调用会被转发到该类的intercept()方法。
class CglibFactory {

    private Hello target;

    public CglibFactory(Hello target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("-------before-------------");
            // 执行目标对象的方法
            Object returnValue = method.invoke(target, objects);
            System.out.println("-------after-------------");
            return returnValue;
        });
        //创建子类对象代理
        return en.create();
    }
}
