package com.chimp.test.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @auther: liux
 * @date: 2019/3/15 10:58
 * @description: TODO
 */
public class SemaphoreTest_2 {

    public static void main(String[] args){
        SemaphoreTest_2 semaphoreTest_2 = new SemaphoreTest_2();
        semaphoreTest_2.test();
    }

    public void test (){
        Semaphore semaphore = new Semaphore(2);
        for (int i=1; i<=20; i++) {
            if (i > 10)  {
                new Thread(new Receiver(semaphore, i, 1)).start();
            } else {
                new Thread(new Receiver(semaphore, i, 2)).start();
            }
        }
    }

    public class Receiver implements Runnable {
        private Integer no;
        private Semaphore semaphore;
        private Integer type;

        public Receiver (Semaphore semaphore, Integer no, Integer type){
            this.semaphore = semaphore;
            this.no = no;
            this.type = type;
        }

        @Override
        public void run() {
            switch (this.type) {
                case 1:
                    try {
                        semaphore.acquire();
                        System.out.println(this.no + "- 收到包裹");
                        Thread.sleep(5000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        if (semaphore.tryAcquire(10, TimeUnit.SECONDS)) {
                            System.out.println(this.no + "- 收到包裹");
                            Thread.sleep(5000);
                            semaphore.release();
                        } else {
                            System.out.println(this.no + "- 拒收包裹");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
