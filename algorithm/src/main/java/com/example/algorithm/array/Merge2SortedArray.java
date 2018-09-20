package com.example.algorithm.array;

import org.apache.commons.lang3.Validate;

public class Merge2SortedArray {
	
	public Integer[] merge(Integer[] a1, Integer[] a2){
		
		Validate.notEmpty(a1, "list1 cannot be null");
		Validate.notEmpty(a2, "list2 cannot be null");
		Integer[] result = new Integer[a1.length + a2.length];
		int l1 = 0, l2 = 0, l3 = 0;
		while(l1 < a1.length && l2 < a2.length){
			if(a1[l1] < a2[l2]){
				result[l3++] = a1[l1++];
			} else {
				result[l3++] = a2[l2++];
			}
		}
		if(l1 < a1.length){
			for(int i=l1; i<a1.length; i++){
				result[l3++] = a1[i];
			}
		}
		if(l2 < a2.length){
			for(int i=l2; i<a2.length; i++){
				result[l3++] = a2[i];
			}
		}
		return result;		
	}

}
