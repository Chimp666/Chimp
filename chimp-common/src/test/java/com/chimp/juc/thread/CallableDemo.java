package com.chimp.juc.thread;

import java.util.concurrent.Callable;

/**
 * @auther: liux
 * @date: 2019/3/13 12:18
 * @description: TODO
 */
class CallableDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("callabale 4000ms....");
        Thread.sleep(4000);
        return 1;
    }
}
