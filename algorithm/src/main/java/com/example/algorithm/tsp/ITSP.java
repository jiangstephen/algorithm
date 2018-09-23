package com.example.algorithm.tsp;

public interface ITSP {
	
	TSPRoute getShortestRoute(String startCity, String[] cities, int[][] distanceMatrix);

}
