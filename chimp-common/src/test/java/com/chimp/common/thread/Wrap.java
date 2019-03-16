package com.chimp.common.thread;

/**
 * @auther: liux
 * @date: 2019/3/13 12:21
 * @description: TODO
 */
public class Wrap implements Runnable {

    @Override
    public void run() {
        System.out.println("wrapper start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wrapper stop");
    }

}
