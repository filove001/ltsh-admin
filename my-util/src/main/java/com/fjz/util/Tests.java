package com.fjz.util;

import com.fjz.util.log.Logs;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/9.
 */
public class Tests {
    public static void forEach(int count,Runnable runnable){
        for (int i = 0; i < count; i++) {
            runnable.run();
        }
    }

    public static void thReadForEach(RunableForEach runnable)  {
        CountDownLatch endLatch = new CountDownLatch(runnable.getThreadNumber());
        runnable.setEndLatch(endLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(runnable.getThreadNumber());
        Times times = new Times();
        times.longTime(new RunableForEach(runnable.getName(),1,1) {
            @Override
            public void action() {
                for (int i = 0; i < runnable.getThreadNumber(); i++) {
                    executorService.submit(runnable);
                }
                try {
                    endLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
       );
    }

}
