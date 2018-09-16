package com.example.algorithm.box.packing;

import lombok.Data;

@Data
public class BoxRow {
	
	private final int capacity;
	
	private int spaceLeft;
	
	private final BoxGrid[] boxGrids;
	
	public BoxRow(int capacity){
		this.capacity = capacity;
		this.spaceLeft = capacity;
		boxGrids = new BoxGrid[capacity];
	}
	
	
	public void occupySpace(int spaceToOccupy, char ch){
		if(spaceToOccupy > spaceLeft){
			throw new IllegalArgumentException("Unable to occupy the space " + spaceToOccupy +", which is bigger than the space left " + spaceLeft);
		}
		for(int i = 0 ; i < spaceToOccupy; i++){
			boxGrids[capacity - spaceLeft + i] = new BoxGrid(ch);
		}
		spaceLeft -= spaceToOccupy;
	}

}
