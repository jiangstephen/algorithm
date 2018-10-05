package com.example.algorithm.sort;

import org.apache.commons.lang3.Validate;

public class QuickSort<T extends Comparable<T>>  implements Sort<T> {

	@Override
	public T[] sort(T[] array) {
		Validate.notEmpty(array, "array should not be empty");
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	private int partition(T[] array, int low, int high){
		T pivot = array[high];
		int i = low;
		for(int j = low; j <= high; j++){
			if(array[j].compareTo(pivot)<0){
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, high);
		return i;
	}
	
	private void quickSort(T[] array, int low, int high){
		if(low >= high){
			return;
		}
		int pivotPos = partition(array, low, high);
		quickSort(array, low, pivotPos - 1);
		quickSort(array, pivotPos+1, high);
	}
	
}
