package org.something;
/*
 * Quick Sort: 
 * Select pivot to divide elements less than pivot to left and others to right and continue this until the left and right array can't be reduced
 * 
 * Base Condition: If initial is less than the end of the array
 * 
 * Recursive relation: Move items less than pivot to left and items greater than pivot to right
 */
import java.util.Arrays;
import java.util.Iterator;

public class Quick extends Sort {
	public static void sortArray(final int[] array, int i, int e) {
		if(i < e) {
			int pivotIndex = partition(array, i, e);
			
			sortArray(array, i, pivotIndex - 1);
			sortArray(array, pivotIndex + 1, e);
		}
	}

	private static int partition(int[] array, int begin, int end) {
	    int pivot = array[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (array[j] <= pivot) {
	            i++;
	            swap(array, i, j);
	        }
	    }
	    swap(array, i+1, end);
	    return i+1;
	}
}
