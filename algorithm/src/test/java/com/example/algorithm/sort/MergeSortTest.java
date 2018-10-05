package com.example.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
	
	private MergeSort<Integer> mergeSort = new MergeSort<>(Integer.class);
	
	@Test
	public void test_sort(){
		Assert.assertArrayEquals(new Integer[]{1}, mergeSort.sort(new Integer[]{1}));
		Assert.assertArrayEquals(new Integer[]{2, 3}, mergeSort.sort(new Integer[]{3, 2}));
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 10, 11}, mergeSort.sort(new Integer[]{3, 2, 1, 5, 10, 11}));
		Assert.assertArrayEquals(new Integer[]{1, 2 , 3, 3, 5, 9, 100, 10000}, mergeSort.sort(new Integer[]{9, 100, 10000, 1, 2 , 3, 3, 5 }));
		Assert.assertArrayEquals(new Integer[]{1, 2 , 3, 3, 5, 9, 100, 10000, 10001, 10002}, 
				mergeSort.sort(new Integer[]{9, 100,10001, 10002,  10000, 1, 2 , 3, 3, 5 }));
	}
}
