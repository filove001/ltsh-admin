package com.fjz.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FileSearchTest {

	@Test
	public void testFindModels() {
		List<FileModel> files =FileSearch.findModels(FileSearchTest.class.getResource("").getFile(), ".class");
		System.out.println(Jsons.toJsonString(files));
		assertTrue(Empty.not(files));
	}

	@Test
	public void testFindFiles() {
		List<String> files =FileSearch.findFiles(FileSearchTest.class.getResource("").getFile(), ".class");
		assertTrue(Empty.not(files));
	}

}
