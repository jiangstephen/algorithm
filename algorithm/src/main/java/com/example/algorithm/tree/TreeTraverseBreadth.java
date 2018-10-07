package com.example.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;

public class TreeTraverseBreadth implements TreeTraverse {


	@Override
	public List<String> traverse(TreeNode rootNode) {
		final List<String> traverseNode = new ArrayList<>();
		traverse(traverseNode, rootNode);
		return traverseNode;
	}


	private void traverse(List<String> traverseNode, TreeNode rootNode) {
		Validate.notNull(rootNode, "root node can not be null");
		Validate.notNull(traverseNode, "traverseNode can not be null");
		if(!traverseNode.contains(rootNode.getName())){
			traverseNode.add(rootNode.getName());
		}
		if(CollectionUtils.isEmpty(rootNode.getNodes())){
			return;
		}
		for(TreeNode children: rootNode.getNodes()){
			if(!traverseNode.contains(children.getName())){
				traverseNode.add(children.getName());
			}
		}
		for(TreeNode children: rootNode.getNodes()){
			traverse(traverseNode, children);
		}
	}
}
