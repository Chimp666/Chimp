package com.chimp.common.thread;

import java.util.concurrent.Callable;

/**
 * @auther: liux
 * @date: 2019/3/13 12:18
 * @description: TODO
 */
class Work implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("worker working");
        Thread.sleep(4000);
        return 1;
    }
}
