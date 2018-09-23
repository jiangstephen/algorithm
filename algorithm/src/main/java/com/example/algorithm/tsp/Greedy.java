package com.example.algorithm.tsp;

import java.util.Set;

public class Greedy extends AbstractTSP implements ITSP {

	public TSPRoute getShortestRoute(String startCity, Object[][] cityGraph) {
		Set<Node> nodeSet = constructGraph(cityGraph);
		return getShortestRoute(startCity, nodeSet);
	}
	
	public TSPRoute getShortestRoute(String startCity, String[] cities, int[][] distanceMatrix) {
		Set<Node> nodeSet = constructGraph(cities, distanceMatrix);
		return getShortestRoute(startCity, nodeSet);
	}
	
	

}
