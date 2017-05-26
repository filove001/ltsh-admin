package com.fjz.util.log;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogsTest {

	@Test
	public void testWarn() {
		Logs.warn("11111111");
	}

	@Test
	public void testInfo() {
		Logs.warn("11111111");
		Logs.info("123213123");
		Logs.warn(new Exception("我们1111"));
	}

	@Test
	public void testError() {
		Logs.warn("11111111");
	}

	@Test
	public void testDbWarn() {
		Logs.warn("11111111");
	}

	@Test
	public void testGetCodeLocation() {
		System.out.println(Logs.getCodeLocation());
	}

}
