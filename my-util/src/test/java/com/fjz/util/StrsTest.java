package com.fjz.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrsTest {

	@Test
	public void testStartsWith() {
//		System.out.println(Strs.startsWith("ab", "a"));
//		System.out.println(Strs.startsWith("ab", "b"));
//		System.out.println(Strs.startsWith("12312", "12"));
//		System.out.println(Strs.startsWith("ABCD", "ab"));
		assertArrayEquals(new Object[]{
				Strs.startsWith("ab", "a"),
				Strs.startsWith("ab", "b"),
				Strs.startsWith("12312", "12"),
				Strs.startsWith("ABCD", "ab"),
				Strs.startsWith(null, "ab")
		}, new Object[]{
				true,
				false,
				true,
				false,
				false
		});
//		fail("Not yet implemented");
	}

}
