package com.example.algorithm.box.packing._2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.algorithm.box.packing.Box;

public class PackBox2DTest {
	
	private PackBox2D testee = new PackBox2D(false);
	private PackBox2D testee2 = new PackBox2D(true);
	
	private List<Box> listBox = Arrays.asList(
			new Box(10, 3, 'a'), new Box(5, 4 , 'b'), new Box(5, 4 , 'c'),
			new Box(3, 1, 'd'), new Box(3, 1, 'e'), new Box(4, 1, 'f'), 
			new Box(10, 1, 'g'), new Box(8,2, 'h'), new Box(2,2,'i'), new Box(2,2,'j'));
	
	
	private List<Box> listBox2 = Arrays.asList(
			new Box(10, 3, 'a'), new Box(1,1, 'b'),
			new Box(2,2, 'c'), 
			new Box(3,6, 'd'), new Box(5,2, 'e'),
			new Box(4,2, 'f'), new Box(6,3, 'g'),
			new Box(9,1, 'h'), new Box(7,6, 'i'));
	
	@Test
	public void test_pack2dBox(){
		testee.find(listBox);
		testee.printRoot();
	}
	
	@Test
	public void test_packBoxWithRandomBoxes(){
		List<Box> listBox = new ArrayList<>();
		for(char i=33;i<123;i++){
			listBox.add(new Box((int)(Math.random()*15), (int)(Math.random()*10), i));
		}
		testee.find(listBox);
		testee.printRoot();
		testee2.find(listBox);
		testee2.printRoot();
	}
}
