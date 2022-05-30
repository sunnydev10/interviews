package com.algorithms.practice.sorting;

public abstract class Sort {
	protected static void printArray(String s, int[] array) {
		System.out.println(s + " : ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i] + " ");
		}
		System.out.println(" ");
	}
	
	/**
	 * @param array the array
	 * @param firstIndex the firstIndex
	 * @param secondIndex the second index
	 */
	protected static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
	    array[firstIndex] = array[secondIndex];
	    array[secondIndex] = temp;
	}
}
