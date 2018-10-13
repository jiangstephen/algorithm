package com.example.algorithm.string;

import org.apache.commons.lang3.Validate;

public class NaiveSearch implements Search{

	@Override
	public int indexOf(String pattern, String input) {
		Validate.notBlank(pattern, "pattern can not be blank");
		Validate.notBlank(input, "the search string can not be blank");
		int m = pattern.length();
		int n = input.length();
		if(n < m){
			return -1;
		}
		for(int i=0;i<n-m+1; i++) {
			for(int j=0; j < m; j++){
				if(pattern.charAt(j) != input.charAt(i+j)){
					break;
				}
				if(j == m - 1){
					return i;
				}
			}
		}
		return -1;
	}

}
