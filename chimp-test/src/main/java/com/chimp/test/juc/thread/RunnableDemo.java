package com.chimp.test.juc.thread;

/**
 * @auther: liux
 * @date: 2019/3/13 12:21
 * @description: TODO
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable stop");
    }

}
