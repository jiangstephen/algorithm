package com.example.algorithm.box.packing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of boxes (height 1, length:arbitrary), create algorithm to 
 * find the width/height of box that holds this set of boxes,  the new box should be as 
 * square-ish as possible 
 * @author stephen.jiang
 * The algorithm here 
 * 1. Sort the boxes with width,  calculate the sqrt root of all the box size
 * 2. For the first box,  determine the first size of the box we want to find, if the width of the box A is bigger 
 * than the sqrt root, then use the A.width to be the width of the final box, otherwise use the sqrt
 * 3. Go to the next box,  try to pack the box with the previous rows otherwise create a new row for it.
 */
public class PackBoxWithDynamicWidth {
	public Box find(List<Box> boxList){
		int boxWidth = 0, boxHeight = 0;
		List<BoxRow> boxRows = new ArrayList<>();
		int sqrtRoot = calculateSquareRootOfAllBoxSize(boxList);
		for(Box box : sortBox(boxList)){
			if(boxWidth == 0){ //the first row
				boxWidth = sqrtRoot >= box.getWidth() ? sqrtRoot : box.getWidth();
				BoxRow boxRow = new BoxRow(boxWidth);
				boxRow.occupySpace(box.getWidth(), box.getCh());;
				boxRows.add(boxRow);
				boxHeight ++;
			}  else { // 2+ boxes
				boolean previousRowSpaceEnough = false;
				for(BoxRow previousRow: boxRows){
					if(previousRow.getSpaceLeft() >= box.getWidth()){
						previousRow.occupySpace(box.getWidth(), box.getCh());
						previousRowSpaceEnough = true;
						break;
					}
				}
				if(!previousRowSpaceEnough){
					boxHeight ++;
					BoxRow boxRow = new BoxRow(boxWidth);
					boxRow.occupySpace(box.getWidth(), box.getCh());
					boxRows.add(boxRow);
				}
			}
			
		}
		return new Box(boxWidth, boxHeight, boxRows);
	}
	
	List<Box> sortBox(List<Box> boxList){
		return boxList.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());
	}
	
	private int calculateSquareRootOfAllBoxSize(List<Box> boxList){
		int surface = 0;
		for(Box box: boxList){
			surface += box.getWidth() * box.getHeight();
		}
		return (int)Math.sqrt(surface) + 1;
	}

}
