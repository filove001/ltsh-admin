package com.fjz.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fjz.util.RepeatCall.Call;

public class RepeatCallTest {

	@Test
	public void testGoCallIntInt() {
	}

	@Test
	public void testGoCallInt() {
		RepeatCall.go(new Call() {
			public void go() {
//				int num=1/0;
//				System.out.println("1111");
			}
		}, 3);
	}

}
