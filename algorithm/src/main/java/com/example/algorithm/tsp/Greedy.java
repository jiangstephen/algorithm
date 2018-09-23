package com.example.algorithm.tsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Greedy {
	
	public List<DirectionalEdge> getShortestRoute(String startCity, Object[][] cityGraph){
		Set<Node> nodeSet = constructGraph(cityGraph);
		List<DirectionalEdge> shortestRoute = new ArrayList<>();
		Node startNode = getNode(nodeSet, startCity);
		getShortestRoute(startNode, startNode, shortestRoute, nodeSet);
		return shortestRoute;
	}
	
	private void getShortestRoute(Node startNode, Node currentNode, List<DirectionalEdge> directionalEdges, Set<Node> nodeToVisit){
		currentNode.setVisited(true);
		nodeToVisit.remove(currentNode);
		int nextShortestDistance = Integer.MAX_VALUE;
		DirectionalEdge shortestDirectionalEdge = null;
		for(DirectionalEdge directionalEdge : currentNode.getDirectionalEdges()){
			if(directionalEdge.getDistance() < nextShortestDistance  && !directionalEdge.getNode2().isVisited()){
				nextShortestDistance = directionalEdge.getDistance();
				shortestDirectionalEdge = directionalEdge;
			} else if (nodeToVisit.isEmpty() && directionalEdge.getNode2().equals(startNode)){
				shortestDirectionalEdge = directionalEdge;
			}
		}
		if(shortestDirectionalEdge != null){
			directionalEdges.add(shortestDirectionalEdge);
			getShortestRoute(startNode, shortestDirectionalEdge.getNode2(), directionalEdges, nodeToVisit);
		}
		
	}
	
	
	
	private Node getNode(Set<Node> nodes, String nodeName){
		for(Node node : nodes){
			if(node.getName().equals(nodeName)){
				return node;
			}
		}
		throw new IllegalArgumentException("Unable to find the node " + nodeName);
	}
	
	private Set<Node> constructGraph(Object[][] cityGraph){
		Map<String, Node> nodesByName= new HashMap<>();
		Set<Node> nodes = new HashSet<>();
		for(Object[] cityDistance : cityGraph){
			Node node1 = getNodeByName(nodesByName, (String)cityDistance[0]);
			Node node2 = getNodeByName(nodesByName, (String)cityDistance[1]);
			int distance = (int)cityDistance[2];
			DirectionalEdge edge1 = new DirectionalEdge(node1, node2, distance);
			node1.addDirectionalEdge(edge1);
			DirectionalEdge edge2 = new DirectionalEdge(node2, node1, distance);
			node2.addDirectionalEdge(edge2);
			nodes.add(node1);
			nodes.add(node2);
		}
		return nodes;
	}
	
	private Node getNodeByName(Map<String, Node> nodesByName, String nodeName){
		if(nodesByName.containsKey(nodeName)){
			return nodesByName.get(nodeName);
		} else {
			Node node = new Node(nodeName);
			nodesByName.put(nodeName, node);
			return node;
		}
	}

}
