package com.example.algorithm.tree;

import org.apache.commons.lang3.Validate;

public class  BinarySearchRecursive<T extends Comparable<T>> implements BinarySearch<T>  {
	
	@Override
	public boolean search(T elementToSearch, T[] array){
		return search(elementToSearch, array, 0, array.length - 1);
	}
	
	private boolean search(T elementToSearch, T[] array, int start, int end){
		Validate.notNull(elementToSearch, "element to search should not be null");
		Validate.notEmpty(array, "array should not be empty");
		int middleIndex = (start + end) / 2;
		T middleElement = array[middleIndex];
		if(elementToSearch.compareTo(middleElement)==0){
			return true;
		}
		if(start == end){
			return false;
		}
		if(elementToSearch.compareTo(middleElement) < 0) {
			return search(elementToSearch, array, start, middleIndex);
		} else {
			return search(elementToSearch, array, middleIndex+1, end);
		}
	}

}
