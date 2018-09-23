package com.example.algorithm.tsp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Node {
	
	private final String name;
	
	private boolean visited;
	
	private List<DirectionalEdge> directionalEdges;

	public Node(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<DirectionalEdge> getDirectionalEdges() {
		return directionalEdges;
	}
	
	public void addDirectionalEdge(DirectionalEdge directionalEdge){
		Validate.notNull(directionalEdge, "directionalEdge should not be null");
		if(directionalEdges == null){
			directionalEdges = new ArrayList<>();
		}
		directionalEdges.add(directionalEdge);		
	}


	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public int hashCode(){
		return new HashCodeBuilder().append(name).build();
	}
	
	@Override
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(!(object instanceof Node)){
			return false;
		}
		return new EqualsBuilder().append(this.name, ((Node)object).name).build();
	}
	
}
