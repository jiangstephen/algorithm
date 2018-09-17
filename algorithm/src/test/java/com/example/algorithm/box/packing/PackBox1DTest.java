package com.example.algorithm.box.packing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PackBox1DTest {
	
	private PackBox1D testee = new PackBox1D();
	
	private List<Box> listBox = Arrays.asList(
			new Box(10, 1, 'a'), new Box(1,1, 'b'),
			new Box(2,1, 'c'), 
			new Box(3,1, 'd'), new Box(5,1, 'e'),
			new Box(4,1, 'f'), new Box(6,1, 'g'),
			new Box(9,1, 'h'), new Box(7,1, 'i'));
	
	@Test
	public void test_sortBox(){
		System.out.println(testee.sortBox(listBox));
	}
	
	@Test
	public void test_packBox(){
		Box box = testee.find(listBox);
		System.out.println(box);
		box.print();
	}
	
	@Test
	public void test_packBoxWithRandomBoxes(){
		List<Box> listBox = new ArrayList<>();
		for(char i=33;i<123;i++){
			listBox.add(new Box((int)(Math.random()*15), 1, i));
		}
		Box box = testee.find(listBox);
		System.out.println(box);
		box.print();
	}

}
