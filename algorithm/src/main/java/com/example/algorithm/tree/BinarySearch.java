package com.example.algorithm.tree;

public interface BinarySearch<T extends Comparable<T>> {

	boolean search(T elementToSearch, T[] array);

}