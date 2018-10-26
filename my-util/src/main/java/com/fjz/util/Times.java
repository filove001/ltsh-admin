package com.fjz.util;


import com.fjz.util.log.Logs;

public class Times {



	private long startTimes;

	public Times() {
		reStartTimes();
	}

	public void reStartTimes() {
		this.startTimes = System.nanoTime();
	}

	public long getTimeDifference() {
		return (System.nanoTime() - startTimes)/1000/1000;
	}
	public long getTimeDifferenceNanoTime(){return System.nanoTime() - startTimes;}

	public void longTime(Runnable runnable) {
		this.reStartTimes();
		runnable.run();
		Logs.info("用时:"+getTimeDifference()+"ms");
	}
	public void longTime(RunableForEach runnable) {
		this.reStartTimes();
		runnable.action();
		Logs.info(runnable.getName()+"用时:"+getTimeDifference()+"ms");
	}
}
