package com.example.algorithm.sort;

import org.apache.commons.lang3.Validate;

public class InsertionSort<T extends Comparable<T>> implements Sort<T>{

	@Override
	public T[] sort(T[] array) {
		Validate.notEmpty(array, "The array should not be empty");
		for(int i = 1 ; i < array.length ; i++){
			for(int j = i ; j > 0 ; j--){
				if(array[j-1].compareTo(array[j]) > 0){
					swap(array, j, j-1);
				}
			}
		}
		return array;
	}
}
