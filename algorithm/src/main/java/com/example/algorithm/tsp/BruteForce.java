package com.example.algorithm.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BruteForce extends AbstractTSP implements ITSP {
	
	public void permute(java.util.List<String> arr, int k, Set<List<String>> result){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1, result);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	result.add(new ArrayList<>(arr));
        }
    }
	
	public TSPRoute getShortestRoute(String startCity, String[] cities, int[][] distanceMatrix) {
		Set<Node> nodeSet = constructGraph(cities, distanceMatrix);
		List<String> cityList = new ArrayList<>(Arrays.asList(cities));
		cityList.remove(startCity);
		Set<List<String>> citiesPermutation = new LinkedHashSet<>();
		permute(cityList, 0, citiesPermutation);
		Set<TSPRoute> allTSPRoute = new TreeSet<>();
		for(List<String> perRoute: citiesPermutation){
			perRoute.add(0, startCity);
			perRoute.add(startCity);
			TSPRoute tspRoute = getTSPRouteGivenListOfCities(perRoute, nodeSet);
			allTSPRoute.add(tspRoute);
			System.out.println(tspRoute);
		}
		return allTSPRoute.iterator().next();
	}
	
	private TSPRoute getTSPRouteGivenListOfCities(List<String> cities, Set<Node> nodeSet){
		TSPRoute tspRoute = new TSPRoute();
		for(int i=0; i < cities.size() - 1 ; i++){
			Node cityNode1 = getNode(nodeSet, cities.get(i));
			Node cityNode2 = getNode(nodeSet, cities.get(i+1));
			for(DirectionalEdge directionalEdge:cityNode1.getDirectionalEdges()){
				if(directionalEdge.getNode2().equals(cityNode2)){
					tspRoute.addEdge(directionalEdge);
				}
			}
		}
		return tspRoute;
	}

}
