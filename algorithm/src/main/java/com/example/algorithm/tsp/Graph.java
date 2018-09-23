package com.example.algorithm.tsp;

import java.util.List;

public class Graph {
	
	private final List<DirectionalEdge> edges;
	
	private final List<Node> nodes;
	
	public Graph(List<Node> nodes, List<DirectionalEdge> edges){
		this.edges = edges;
		this.nodes = nodes;
	}

	public List<DirectionalEdge> getEdges() {
		return edges;
	}

	public List<Node> getNodes() {
		return nodes;
	}
	
}
