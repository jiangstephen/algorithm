package com.example.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

public class Merge2SortedArrayTest {
	
	private Merge2SortedArray testee = new Merge2SortedArray();
	
	@Test
	public void test_mergeSort(){
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 7, 8, 10, 11},  testee.merge(new Integer[]{2, 5, 7, 11}, new Integer[]{1,3,8, 10}));
	}

}
