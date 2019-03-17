package com.chimp.common.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CallableDemo callableDemo = new CallableDemo();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> result = executorService.submit(callableDemo);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("isdone :" + result.isDone());
        System.out.println("time :" + (System.currentTimeMillis() - start));

        try {
            System.out.println("result: " + result.get());
            System.out.println("time :" + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
