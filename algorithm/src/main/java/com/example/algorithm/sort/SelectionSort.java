package com.example.algorithm.sort;

import org.apache.commons.lang3.Validate;

public class SelectionSort<T extends Comparable<T>> implements Sort<T>{

	//detect the smallest element from the unsorted array and put in the beginning of the array
	@Override
	public T[] sort(T[] array) {
		Validate.notEmpty(array, "The array should not be empty");
		int index;
		for(int i = 0 ; i < array.length ; i++){
			index = i;
			for(int j = i+1 ; j< array.length ; j++){
				if(array[i].compareTo(array[j]) > 0){
					index = j;
				}
			}
			T smallerOne = array[index];
			array[index] = array[i];
			array[i] = smallerOne;
		}
		return array;
	}
}
