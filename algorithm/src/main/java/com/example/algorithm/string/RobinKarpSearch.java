package com.example.algorithm.string;

import org.apache.commons.lang3.Validate;

public class RobinKarpSearch implements Search {

	@Override
	public int indexOf(String pattern, String input) {
		Validate.notBlank(pattern, "pattern can not be blank");
		Validate.notBlank(input, "the search string can not be blank");
		int m = pattern.length();
		int n = input.length();
		if (n < m) {
			return -1;
		}
		int patternHash = pattern.hashCode();
		for (int i = 0; i < n - m + 1; i++) {
			String subStr = input.substring(i, i + m );
			if (subStr.hashCode() == patternHash && pattern.equals(subStr)) {
				return i;
			}
		}
		return -1;
	}
}
