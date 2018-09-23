package com.example.algorithm.tsp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TSPRoute implements Comparable<TSPRoute> {
	
	private Integer totalDistance = 0;
	private List<DirectionalEdge> edges;
	
	public void addEdge(DirectionalEdge directionalEdge){
		if(edges == null){
			edges = new ArrayList<>();
		}
		edges.add(directionalEdge);
		totalDistance += directionalEdge.getDistance();
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public Integer getTotalDistance() {
		return totalDistance;
	}

	@Override
	public int compareTo(TSPRoute o) {
		if(o == null){
			return -1;
		}
		return this.totalDistance.compareTo(o.totalDistance);
	}

}
