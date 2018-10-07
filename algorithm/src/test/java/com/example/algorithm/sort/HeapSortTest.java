package com.example.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {
	
	private HeapSort<Integer> heapSort = new HeapSort<>();
	
	@Test
	public void test_sort(){
		Assert.assertArrayEquals(new Integer[]{1}, heapSort.sort(new Integer[]{1}));
		Assert.assertArrayEquals(new Integer[]{2, 3}, heapSort.sort(new Integer[]{3, 2}));
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5, 10, 11}, heapSort.sort(new Integer[]{3, 2, 1, 5, 10, 11}));
		Assert.assertArrayEquals(new Integer[]{1, 2 , 3, 3, 5, 9, 100, 10000}, heapSort.sort(new Integer[]{9, 100, 10000, 1, 2 , 3, 3, 5 }));
		Assert.assertArrayEquals(new Integer[]{1, 2 , 3, 3, 5, 9, 100, 10000, 10001, 10002}, 
				heapSort.sort(new Integer[]{9, 100,10001, 10002,  10000, 1, 2 , 3, 3, 5 }));
	}
}
