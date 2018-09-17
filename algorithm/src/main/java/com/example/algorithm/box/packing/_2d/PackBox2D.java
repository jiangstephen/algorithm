package com.example.algorithm.box.packing._2d;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;

import com.example.algorithm.box.packing.Box;

/**
 * Given a list of boxes (height arbitrary, length:arbitrary), create algorithm to 
 * find the width AND height of box that holds this set of boxes,  the new box should be as 
 * square-ish as possible 
 * @author stephen.jiang
 * The algorithm here https://github.com/jakesgordon/bin-packing/blob/master/js/packer.growing.js
 */
public class PackBox2D {
	
	private Node root;
	
	List<Box> sortBox(List<Box> boxList){
		return boxList.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());
	}
	
	public void find(List<Box> boxList){
		Validate.notEmpty(boxList, "boxList should not be empty");
		List<Box> sortedBoxes = sortBox(boxList);
		Box biggestBox = sortedBoxes.get(0);
		root = new Node(0, 0, biggestBox.getWidth(), biggestBox.getHeight());
		for(Box box : sortedBoxes){
			Optional<Node> node = this.findNode(root, box);
			if(node.isPresent()){
				this.splitNode(node.get(), box);
			} else {
				this.growNodeAndFit(box);
			}
		}
	}
	
	private Optional<Node> findNode(Node root, Box box){
		if(root.isUsed()){
			Optional<Node> foundNode = this.findNode(root.getRight(), box) ;
			if(foundNode.isPresent()){
				return foundNode;
			}
			return this.findNode(root.getDown(), box);
		} else if (root.getWidth() >= box.getWidth() && root.getHeight() >= box.getHeight()){
			System.out.println("The node is not used, return the node " + root +" for box " + box);
			return Optional.of(root);
		} else {
			return Optional.empty();
		}
		
	}
	
	private void splitNode(Node node, Box box){
		node.setUsed(true);
		this.root.fillBox(node, box);
		node.setDown(new Node(node.getStartX(), node.getStartY() + box.getHeight(), node.getWidth(), node.getHeight() - box.getHeight()));
		node.setRight(new Node(node.getStartX() + box.getWidth(), node.getStartY(), node.getWidth() - box.getWidth(), box.getHeight()));
		System.out.println("Split the node " + node+" for the box " + box);
	}
	
	private void growNodeAndFit(Box box){
		Validate.notNull(box, "box should not be null");
		boolean canGrowDown = (box.getWidth() <= this.root.getWidth());
		boolean canGrowRight = (box.getHeight() <= this.root.getHeight());
		boolean shouldGrowRight = canGrowRight && (this.root.getHeight() >= (this.root.getWidth() + box.getWidth()));
		boolean shouldGrowDown = canGrowDown && (this.root.getWidth() >= (this.root.getHeight() + box.getHeight()));
		if(shouldGrowRight){
			System.out.println("should grow right for the box " + box);
			this.growRightAndFit(box);
		}
		else if(shouldGrowDown) {
			System.out.println("should grow down for the box " + box);
			this.growDownAndFit(box);
		}
		else if(canGrowRight){
			System.out.println("can grow right for the box " + box);
			this.growRightAndFit(box);
		}
		else if(canGrowDown){
			System.out.println("can grow down for the box " + box);
			this.growDownAndFit(box);
		}
		else {
			throw new IllegalStateException("Unable to grow in any direction");
		}
	}

	private void growDownAndFit(Box box) {
		Node newRoot = new Node(0,0, this.root.getWidth(), this.root.getHeight() + box.getHeight());
		newRoot.setUsed(true);
		newRoot.setDown(new Node(0, this.root.getHeight(), this.root.getWidth(), box.getHeight()));
		newRoot.setRight(this.root);
		newRoot.copyGridFromNode(this.root);
		this.root = newRoot;
		Optional<Node> foundNode = this.findNode(root, box);
		if(foundNode.isPresent()){
			this.splitNode(foundNode.get(), box);
		} else {
			throw new IllegalStateException("Something is wrong, should find the node after growing down");
		}
	}

	private void growRightAndFit(Box box) {
		Node newRoot = new Node(0,0, this.root.getWidth() + box.getWidth(), this.root.getHeight());
		newRoot.setDown(this.root);
		newRoot.setRight(new Node(this.root.getWidth(), 0, box.getWidth(), this.root.getHeight()));
		newRoot.setUsed(true);
		newRoot.copyGridFromNode(this.root);
		this.root = newRoot;
		Optional<Node> foundNode = this.findNode(this.root, box);
		if(foundNode.isPresent()){
			this.splitNode(foundNode.get(), box);
		} else {
			throw new IllegalStateException("Something is wrong, should find the node after growing down");
		}
	}
	
	public void printRoot(){
		root.print();
	}
}
