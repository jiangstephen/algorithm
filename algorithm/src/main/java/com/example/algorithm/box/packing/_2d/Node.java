package com.example.algorithm.box.packing._2d;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.example.algorithm.box.packing.Box;
import com.example.algorithm.box.packing.BoxGrid;

import lombok.Data;

@Data
public class Node {
	
	private final int startX;
	private final int startY;
	private int width;
	private int height;
	private Node right;
	private Node down;
	private boolean used;
	private BoxGrid[][] boxGridArray;
	
	public Node(int startX, int startY, int width, int height){
		this.startX = startX;
		this.startY = startY;
		this.width = width;
		this.height = height;
		boxGridArray = new BoxGrid[height][width];
	}
	
	public void increaseHeight(int height){
		this.height = this.height + height;
	}
	
	public void increaseWidth(int width){
		this.width = this.width + width;
	}
	
	public void fillBox(Node node, Box box){
		for(int i = node.getStartY(); i < node.getStartY() + box.getHeight(); i++) {
			for( int j = node.getStartX(); j < node.getStartX() + box.getWidth(); j++) {
				try {
					//System.out.println("filling the node " + node +", box=" + box);
					boxGridArray[i][j] = new BoxGrid(box.getCh());
				} catch(Exception e){
					System.out.println("problem occurred when filling the node " + node +", box=" + box);
				}
			}
		}
	}
	
	public void copyGridFromNode(Node node){
		if(node.height > this.height || node.width > this.width){
			throw new IllegalStateException("the node["+node.width+ "," +node.height+ "] to copy has the dimension then current node ["+this.width+"," + this.height+ "]");
		}
		for(int i = 0; i < node.getHeight(); i++) {
			for( int j = 0; j < node.getWidth(); j++) {
				boxGridArray[i][j] = node.boxGridArray[i][j];
			}
		}
	}
	
	
	public void print(){
		System.out.println(new ToStringBuilder(this).append("width=" + width).append("height=" + height));
		for(BoxGrid[] boxGrids: boxGridArray){
			System.out.println();
			for(BoxGrid boxGrid: boxGrids){
				System.out.print(boxGrid!=null?boxGrid.getCh():' ');
			}
		}
		System.out.println();
	}
}
