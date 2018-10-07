package com.example.algorithm.tree;

import org.apache.commons.lang3.Validate;

public class BinarySearchLoop<T extends Comparable<T>> implements BinarySearch<T>  {

	@Override
	public boolean search(T elementToSearch, T[] array) {
		Validate.notNull(elementToSearch, "elementToSearch can not be null");
		Validate.notEmpty(array, "array can not be empty");
		int endIndex = array.length - 1;
		int startIndex = 0;
		do{
			int middleIndex = (startIndex + endIndex)/2;
			T middleElement = array[middleIndex];
			if(elementToSearch.compareTo(middleElement)==0){
				return true;
			}
			if(endIndex == startIndex){
				return false;
			}
			if(elementToSearch.compareTo(middleElement)>0){
				startIndex = middleIndex + 1;
			} else {
				endIndex = middleIndex;
			} 
			
		} while(true);
	}

}
