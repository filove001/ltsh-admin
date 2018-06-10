package com.fjz.util;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/6/9.
 */
public abstract class RunableForEach implements Runnable{
        //每个线程循环数量
        private int threadLoopCount = 1000;
        //线程数量
        private int threadNumber =0;
        private CountDownLatch endLatch;
        private String name;
        public void setEndLatch(CountDownLatch endLatch) {
            this.endLatch = endLatch;
        }
        public String getName() {
            return name;
        }

    public int getThreadLoopCount() {
        return threadLoopCount;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public RunableForEach(String name, int threadNumber, int threadLoopCount) {
            this.threadLoopCount = threadLoopCount;
            this.threadNumber = threadNumber;
            this.name = name;
        }

    @Override
        public void run() {
            for (int i = 0; i < threadLoopCount; i++) {
                action();
            }
            endLatch.countDown();
        }
        public abstract void action();
}
