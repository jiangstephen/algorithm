package com.example.algorithm.sort;

/*
        1
      /   \
     2     3
    /\     /\
   4  5   6  7 
*/   
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] array) {
		int size = array.length;
		for(int i = size / 2 - 1; i>=0; i--){
			heapify(array, size, i);
		}
		for(int i = size - 1; i >=0 ; i-- ){
			swap(array, 0, i);
			heapify(array, i, 0);
		}
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @param n  the size of the heap
	 * @param root  the root index of the heap
	 */
	private void heapify(T[] array, int n, int root){
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		if(left < n && array[left].compareTo(array[largest])>0){  //if the left is bigger than root
			largest = left;
		}
		if(right < n && array[right].compareTo(array[largest])>0){
			largest = right;
		}
		if(largest != root){
			swap(array, largest, root);
			heapify(array, n, largest);
		}
	}

}
