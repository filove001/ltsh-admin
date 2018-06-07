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

	public void time(Runnable runnable) {
		this.reStartTimes();
		runnable.run();
		System.out.println("用时:"+getTimeDifference());
	}
}
