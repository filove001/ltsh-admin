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
		String temp="{\n" +
				"\"userKey\":\"4cdc1b2b80ccec727da447dbc5413f2a4b98ac461ef597a793c7d9ee4572d40a559e5e470ef0a9bb04066c53b4a1a78293c24c3a9c73f32417ebec9320a617064c6e25ce1aa998a73e999bb344a8b0b0d6f828633b51c7e1a46b92527804efdf2a3ec7ab3add421cd3c94ee3399c9bbc72c84d58acdfc1b6e17f29e5244e4c97\",\n" +
				"\"checkParams\":\"123\",\n" +
				"\"appoOrderInfo\":\n" +
				"{\n" +
				"\"patiID\":\"402880b45aec03b7015af3f8d08c0059\",\n" +
				"\"patiName\":\"福泉丰\",\n" +
				"\"hospitalID\":\"newpool_602\",\n" +
				"\"hospitalName\":\"深圳市人民医院测试\",\n" +
				"\"deptID\":\"newpool_602_6905\",\n" +
				"\"deptName\":\"神经内科\",\n" +
				"\"doctorID\":\"newpool_602_6905_28677\",\n" +
				"\"doctorName\":\"陈伟宏\",\n" +
				"\"cardType\":\"1\",\n" +
				"\"cardNum\":\"35050319830323916X\",\"\n" +
				"\"regiFee\":\"17.00\",\n" +
				"\"regiTreatFee\":\"0\",\n" +
				"\"sex\":\"2\",\n" +
				"\"phoneNum\":\"17010000002\",\n" +
				"\"birthday\":\"1983-03-23\",\n" +
				"\"ybCard\":\"\",\n" +
				"\"familyID\":\"\",\n" +
				"\"guardID\":\"\",\n" +
				"\"archiveID\":\"\",\n" +
				"\"regiDate\":\"2017-10-21\",\n" +
				"\"timeFlag\":\"1\",\n" +
				"\"regiSartTime\":\"09:00\",\n" +
				"\"regiEndTime\":\"09:30\",\n" +
				"\"regSourceID\":\"181942\",\n" +
				"\"detlID\":\"181942\"\n" +
				"}\n";
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
