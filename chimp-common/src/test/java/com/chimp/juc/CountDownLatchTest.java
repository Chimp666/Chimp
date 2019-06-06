package com.chimp.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args){

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    System.out.println("线程:" + Thread.currentThread().getName() + "正在运行！");
                    Thread.sleep(3000);
                    System.out.println("线程:" + Thread.currentThread().getName() + "结束！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    System.out.println("线程:" + Thread.currentThread().getName() + "正在运行！");
                    Thread.sleep(3000);
                    System.out.println("线程:" + Thread.currentThread().getName() + "结束！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
