package com.example.algorithm.box.packing;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Data;

@Data
public class Box implements Comparable<Box>{

	private final int width;
	private final int height;
	private char ch;
	private BoxGrid[][] boxGridArray;
	
	public Box(int width, int height, char ch){
		this.width = width;
		this.height = height;
		this.ch = ch;
		boxGridArray = new BoxGrid[height][width];
		for(int i=0; i<height; i++){
			for(int j=0; j < width; j++){
				boxGridArray[i][j] = new BoxGrid(ch);
			}
		}
	}
	
	public Box(int width, int height, List<BoxRow> boxRows){
		this.width = width;
		this.height = height;
		boxGridArray = new BoxGrid[height][width];
		int i = 0; 
		for(BoxRow boxRow : boxRows){
			int j = 0;
			for(BoxGrid boxGrid: boxRow.getBoxGrids()){
				boxGridArray[i][j++] = boxGrid;
			}
			i++;
		}
	}
	
	public int compareTo(Box box) {
		Validate.notNull(box, "box should not be null");
		int compareWidth = -(new Integer(this.width).compareTo(box.width));
		if(compareWidth != 0){
			return compareWidth;
		}
		int compareHeight = -(new Integer(this.height).compareTo(box.height));
		if(compareHeight == 0){
			return compareWidth;
		}
		return new Character(this.getCh()).compareTo(box.getCh());
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object box){
		return EqualsBuilder.reflectionEquals(this, box);
	}
	
	public void print(){
		
		for(BoxGrid[] boxGrids: boxGridArray){
			System.out.println();
			for(BoxGrid boxGrid: boxGrids){
				System.out.print(boxGrid!=null?boxGrid.getCh():' ');
			}
		}
		System.out.println();
	}

}
