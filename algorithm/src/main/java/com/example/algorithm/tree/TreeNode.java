package com.example.algorithm.tree;

import java.util.List;

public class TreeNode {
	
	private final String name;
	
	private List<TreeNode> nodes;
	
	public TreeNode(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNode> nodes) {
		this.nodes = nodes;
	}
	
	

}
