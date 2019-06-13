package com.chimp.test.proxy;

/**
 * @auther: liux
 * @date: 2019/6/13 16:16
 * @description: TODO
 */
class HelloImp implements Hello{
    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }

    @Override
    public String saySorry(String name) {
        System.out.println("sorry");
        return "Sorry," + name;
    }
}