package com.example.algorithm.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchLoopTest {
	
	private BinarySearch<Integer> testee = new BinarySearchLoop<Integer>();
	
	@Test
	public void test_search(){
		Integer[] array =  new Integer[]{1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 19};
		Assert.assertTrue(testee.search(1, array));
		Assert.assertFalse(testee.search(8, array));
		Assert.assertTrue(testee.search(3, array));
		Assert.assertFalse(testee.search(18, array));
		Assert.assertTrue(testee.search(19, array));		
		Assert.assertFalse(testee.search(19, new Integer[]{0}));
		Assert.assertTrue(testee.search(1, new Integer[]{1,2}));	
		Assert.assertTrue(testee.search(2, new Integer[]{1,2}));
		Assert.assertTrue(testee.search(2, new Integer[]{2}));
	}

}
