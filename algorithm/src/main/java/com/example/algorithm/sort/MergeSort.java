package com.example.algorithm.sort;

import java.lang.reflect.Array;

import org.apache.commons.lang3.Validate;

public class MergeSort<T extends Comparable<T>> implements Sort<T>{
	
	private final Class<T> clazz;
	
	public MergeSort(Class<T> clazz){
		this.clazz = clazz;
	}

	@Override
	public T[] sort(T[] array) {
		Validate.notEmpty(array, "array should not be empty");
		mergeSort(array, 0, array.length -1);
		return array;
	}
	
	
	private void mergeSort(T[] array, int low, int high){
		if(low >= high) {
			return;
		}
		int middleIndex = (low + high )/2;
		mergeSort(array, low, middleIndex);
		mergeSort(array, middleIndex + 1, high);
		mergeSplittedArrays(array, low, middleIndex, high);
	}
	
	private void mergeSplittedArrays(T[] array, int low, int middleIndex, int high){
		int i = low; 
		int j = middleIndex + 1;
		int index = 0;
		@SuppressWarnings("unchecked")
		T[] tmpArray= (T[]) Array.newInstance(clazz, high-low+1);
		while(i <= middleIndex && j <= high){
			if(array[i].compareTo(array[j])>0){
				tmpArray[index++] = array[j++];
			} else {
				tmpArray[index++] = array[i++];
			}
		}
		while(i <= middleIndex){
			tmpArray[index++] = array[i++];
		}
		while(j <= high){
			tmpArray[index++] = array[j++];
		}
		for(int k=0; k<index; k++){
			array[low+k] = tmpArray[k];
		}
	}
	
	

}
