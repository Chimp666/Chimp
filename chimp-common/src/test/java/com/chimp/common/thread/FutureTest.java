package com.chimp.common.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther: liux
 * @date: 2019/3/13 11:44
 * @description: TODO
 */
public class FutureTest {

    public static void main(String[] args) {
        Work work = new Work();
        FutureTask<Integer> futureTask = new FutureTask<>(work);
        new Thread(futureTask).start();

       Wrap wrap = new Wrap();
       Thread runThread = new Thread(wrap);
       runThread.start();



       Thread thread = new Thread(){
           public void run(){
               System.out.println("thread running");
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("thread stop");
           }
       };
       thread.start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
