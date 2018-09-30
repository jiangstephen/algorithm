package com.example.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
	
	private InsertionSort<Integer> testee = new InsertionSort<Integer>();
	
	@Test
	public void sortArrayOfInteger(){
		Assert.assertArrayEquals(new Integer[]{1}, testee.sort(new Integer[]{1}));
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5}, testee.sort(new Integer[]{ 3, 2 , 5, 1}));
		Assert.assertArrayEquals(new Integer[]{ 2, 7, 10, 34, 42, 56, 67, 88}, testee.sort(new Integer[]{10,34,2,56,7,67,88,42})); 
	}

}
