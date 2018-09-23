package com.example.algorithm.tsp;

import java.util.List;

import org.junit.Test;

public class GreedyTest {
	
	private final Object[][] cityGraph = new Object[][]{
		{"A", "B", 10},
		{"A", "C", 9},
		{"A", "D", 8},
		{"B", "C", 5},
		{"B", "D", 2},
		{"C", "D", 3}};
		//A->D(8), D->B(2), B->C(5), C->A(9)
	
	private Greedy testee = new Greedy();
	
	@Test
	public void test_getShortestRoute(){
		List<DirectionalEdge> directionalEdges = testee.getShortestRoute("A", cityGraph);
		System.out.println(directionalEdges);
	}

}
