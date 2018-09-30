package com.example.algorithm.misc;

import org.junit.Assert;
import org.junit.Test;

public class PrimeNumbersTest {
	
	@Test
	public void test_primeNumbers(){
		Assert.assertFalse(PrimeNumbers.isPrime(1));
		Assert.assertTrue(PrimeNumbers.isPrime(2));
		Assert.assertTrue(PrimeNumbers.isPrime(3));
		Assert.assertFalse(PrimeNumbers.isPrime(4));
		Assert.assertTrue(PrimeNumbers.isPrime(5));
		Assert.assertTrue(PrimeNumbers.isPrime(7));
		Assert.assertTrue(PrimeNumbers.isPrime(19861));
	}

}
