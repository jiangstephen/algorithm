package com.example.algorithm.tree;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTraverseTest {
/**
	   Root
	   /  \
	  A    B
	 / \
	C   D
   /    \
  E	     F
*/	 
	private TreeTraverseDepth treeTraverserDepth = new TreeTraverseDepth();
	private TreeTraverseBreadth treeTraverserBreadth = new TreeTraverseBreadth();
	
	
	private TreeNode root = new TreeNode("root");
	private TreeNode nodeA = new TreeNode("A"), nodeB = new TreeNode("B"), 
			nodeC = new TreeNode("C"), nodeD = new TreeNode("D"), 
			nodeE = new TreeNode("E"), nodeF = new TreeNode("F");
	
	@Before
	public void setUp(){
		root.setNodes(Arrays.asList(nodeA, nodeB));
		nodeA.setNodes(Arrays.asList(nodeC, nodeD));
		nodeC.setNodes(Arrays.asList(nodeE));
		nodeD.setNodes(Arrays.asList(nodeF));
		
	}
	
	@Test
	public void test_traverse(){
		Assert.assertArrayEquals(new String[]{"root", "A", "C", "E", "D", "F", "B"}, treeTraverserDepth.traverse(root).toArray());
		Assert.assertArrayEquals(new String[]{"root", "A", "B", "C", "D", "E", "F"}, treeTraverserBreadth.traverse(root).toArray());
	}

}
