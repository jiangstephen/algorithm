package com.example.algorithm.misc;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	
	public static  boolean isPrime(int number){
		if(number <= 1){
			return false;
		}
		if(number <= 3){
			return true;
		}
		if(number % 2 ==0 || number % 3 == 0){
			return false;
		}
		for(int i = 5; i * i <= number ; i = i + 6){
			if(number % i == 0 || number % (i + 2) == 0){
				return false;
			}
		}
		return true;	
	}
	
	public static void main(String args[]){
		List<Integer> primeList = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		for( int i = 4; i < 10_000_000; i++ ){
			if(isPrime(i)){
				primeList.add(i);
			}
		}
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(" Calculated in " + (timeElapsed) +" ms, there are  " + primeList.size()
		+ " prime numbers from 2 to 1,000,000"); // which are " + primeList.toString() );
		
	}

}
