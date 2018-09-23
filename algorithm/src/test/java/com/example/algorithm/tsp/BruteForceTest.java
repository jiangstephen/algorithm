package com.example.algorithm.tsp;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

public class BruteForceTest {
	
	private BruteForce testee = new BruteForce();
	
	@Test
    public void test_permute(){
		Set<List<String>> result = new LinkedHashSet<>();
        testee.permute(java.util.Arrays.asList("A","B","C","D","E"), 0, result);
        System.out.println(result);
    }
	
	@Test
    public void test_getShortestRoute(){
		System.out.println(testee.getShortestRoute("A", Constants.cityNames2, Constants.distMatrix2));
    }
	
	@Test
	@Ignore("Impossible to do the calcuation on 500million permutation")
    public void test_getShortestRoute_usa(){
		System.out.println(testee.getShortestRoute("New York", Constants.cityNames, Constants.distMatrix));
    }

}
