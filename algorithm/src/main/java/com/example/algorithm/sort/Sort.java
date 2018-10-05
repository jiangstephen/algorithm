package com.example.algorithm.sort;

public interface Sort<T extends Comparable<T>> {
	
	T[] sort(T[] array);
	
	default void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
