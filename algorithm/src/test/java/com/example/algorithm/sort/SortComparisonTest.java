package com.example.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortComparisonTest {
	
	private Double[] generateRandomArray(int size, Double maxValue){
		Double[] tmpArray = new Double[size]; 
		for(int i=0; i<size ; i++){
			tmpArray[i] = Math.random() * maxValue; 
		}
		return tmpArray;
	}
	
	@Test 
	public void compareStortAlgorithm() throws InterruptedException{
		Double[] doubleArray = generateRandomArray(10_000_000, 100_000_000d);
		
		Sort[] sortAlgorithms = new Sort[]{
				//new InsertionSort<>(), 
				new HeapSort<>(), 
				//new SelectionSort<>(), 
				new QuickSort<>(), 
				new MergeSort<>(Double.class)};
		List<Thread> threads = new ArrayList<>();
		for(Sort sort : sortAlgorithms){
			Double[] newDoubleArray = new Double[doubleArray.length];
			System.arraycopy(doubleArray, 0, newDoubleArray, 0, doubleArray.length);
			Thread thread = new Thread(()-> {
				System.out.println("Start sorting for " + sort.toString());
				long startTime = System.currentTimeMillis();
				sort.sort(newDoubleArray);
				long endTime = System.currentTimeMillis();
				System.out.println("Sorting for " + sort.toString() +" for  " + doubleArray.length +" elements, elapsed time " + (endTime - startTime) +" ms");
			});
			thread.start();
			threads.add(thread);
		}
		for(Thread thread : threads){
			thread.join();
		}
	}

}
