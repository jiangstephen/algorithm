package com.example.algorithm.tsp;

import org.junit.Test;

public class GreedyTest {
	

	private Greedy testee = new Greedy();
	
	@Test
	public void test_getShortestRoute_byEdges(){
		TSPRoute shortestRoute = testee.getShortestRoute("A", Constants.cityGraph);
		System.out.println(shortestRoute);
	}
	
	@Test
	public void test_getShortestRoute_byMatrix(){
		TSPRoute shortestRoute = testee.getShortestRoute("New York", Constants.cityNames, Constants.distMatrix);
		System.out.println(shortestRoute);
	}
	
	@Test
	public void test_getShortestRoute_byMatrix2(){
		TSPRoute shortestRoute = testee.getShortestRoute("A", Constants.cityNames2, Constants.distMatrix2);
		System.out.println(shortestRoute);
	}

}
