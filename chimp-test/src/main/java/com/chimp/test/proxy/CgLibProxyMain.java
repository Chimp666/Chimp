package com.chimp.test.proxy;

/**
 * @auther: liux
 * @date: 2019/6/13 17:18
 * @description: TODO
 */
public class CgLibProxyMain {

    public static void main(String args[]){
//        Hello hello = (Hello) new CglibInterceptor(new HelloImp()).getProxyInstance();
        Hello hello = (Hello) new CglibFactory(new HelloImp()).getProxyInstance();

        System.out.println(hello.saySorry("I love you!"));
    }

}
