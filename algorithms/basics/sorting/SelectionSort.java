package org.something;
/*
 * What is selection sort.
 * For each iteration find the Min value and swap it to the beginning.
 */
public class SelectionSort {
	public static void sortArray(final int[] array) {
		for (int i = 0; i < array.length; i++) {
			int k = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if(array[j] < k) {
					array[i] = array[j];
					array[j] = k;
					k = array[i];
				}
			}
		}
	}
}
