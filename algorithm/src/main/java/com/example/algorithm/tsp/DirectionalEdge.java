package com.example.algorithm.tsp;

public class DirectionalEdge {
	
	private final Node node1;
	private final Node node2;
	private final int distance;
	
	public DirectionalEdge(Node node1, Node node2, int distance){
		this.node1 = node1;
		this.node2 = node2;
		this.distance = distance;
	}

	public Node getNode1() {
		return node1;
	}

	public Node getNode2() {
		return node2;
	}

	public int getDistance() {
		return distance;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append(node1.getName())
				.append("->")
				.append(node2.getName()).append("(" + distance +")").toString();
	}
	
}
