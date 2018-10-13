package com.example.algorithm.string;

public class KMPSearch implements Search{

	@Override
	public int indexOf(String pattern, String input) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	private char[] computePrefixFunction(String pattern){
		int m = pattern.length();
		char[] pi = new char[m];
		pi[0] = 0;
		int k = 0;
		for( int q = 1; q<m; q++){
			while(k>0 && pattern.charAt(k+1) != pattern.charAt(q)){
				k = pi[k];
			}
			if(pattern.charAt(k+1) == pattern.charAt(q)){
				k++;
			}
			pi[q] = (char)k;
		}
		return pi;
	}
	
	public static void main(String args[]){
		System.out.println(new String(new KMPSearch().computePrefixFunction("abcdefg")));
	}

}
