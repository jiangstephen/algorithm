package com.example.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {
	
	private SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
	
	@Test
	public void sortArrayOfInteger(){
		Assert.assertArrayEquals(new Integer[]{1}, selectionSort.sort(new Integer[]{1}));
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 5}, selectionSort.sort(new Integer[]{1, 3, 2 , 5}));
	}

}
