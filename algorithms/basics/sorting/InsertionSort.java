package org.something;

/*
 * what is insertion sort?
 * Value form the unsorted place is picked and moved to sort place
 *  
 * 5 6 3 1 8 7 2 4
 * initial sorted index = 1; while (sort index >= 0 && sorted set has greater values) swap; 
 */

public class InsertionSort extends Sort{
	
	public static void sortArray(int[] array) {
		int n = array.length;
		for(int i = 1; i < n; i++) {
			// i is partion index
			int j = i;
			while(j > 0 && array[j] < array[j - 1]) {
				swap(array, j, j-1);
				j--;
			}
		}
	}
	
	public static void optimizedSortArray(final int[] array) {
		for (int i = 0; i < array.length; i++) { // 0 , 1, 2
			int j = i - 1; // -1 , 0, 1
			int key = array[i]; // 5, 6, 3
			while (j >= 0 && array[j] > key) { // , true && 5 > 6 , true && 6 > 3
				array[j + 1] = array[j]; //  a[1] = 3 , 5 6 6 1 8 7 2 4
				j--; // 0
			}
			array[j + 1] = key; // [5,6,3,1,8,7,2,4],  [5,6,3,1,8,7,2,4], 
		}
	}
}
