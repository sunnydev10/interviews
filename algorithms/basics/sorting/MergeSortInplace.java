package org.something;

import java.util.Arrays;

/*
 * What is merge sort.
 * We divide the list of elements and merge them back in the sorting order.
 * 
 * Base Case: If length is one
 * 
 * Recurrence Relation: divide and merge left and right elements in correct order
 * f([99, 44, 6]) = f(f([99, 44]) <-> f([6])) = f(f(f([99]) <-> f([44])) <-> f([6])) = f([99, 44]) <-> f([6])) = f([99, 44]) <-> f[6]) = [6, 99, 44]
 * 
 * sort ({ 99, 44, 6, 2 }, 4)
 * m = 2
 * n1 = 2
 * n2 = 2
 * L = [ 99 , 44 ]
 * R = [ 6, 2 ]
 * sortArray([99, 44], 2), sortArray([6, 2], 2), merge(arr, [99, 44], [6, 2], 0, 3)
 * 
 * sortArray([99, 44], 2)
 * m = 1
 * n1 = 1
 * n2 = 1
 * L = [ 99 ]
 * R = [ 44 ]
 * sortArray([99], 1), sortArray([44], 1), merge(arr, [99], [44], 1, 0, 1)
 * 
 * sortArray([99], 1)
 * exit
 * 
 * sortArray([44], 1)
 * exit
 * 
 * merge([ 99 , 44 , 6, 2], [99], [44], 1)
 * i = 0, j = 0, k = 0
 * n1 =1 , n2 =1
 */
public class MergeSortInplace extends Sort{
	
	public static void sortArray(int arr[], int n)
    {
	if(n < 2) {
		return;
	}
        int m = n / 2;
        int n1 = m;
        int n2 = n - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
            for (int i = 0; i < n1; i++)
                L[i] = arr[i];
            for (int j = 0; j < n2; j++)
                R[j] = arr[j + m];

        	sortArray(L, n1);
        	sortArray(R, n2);
  
            merge(arr, L, R);
    }
	
	private static void merge(int arr[], int[] L, int[] R)
    {
        int i = 0, j = 0, k = 0;
        int n1 = L.length, n2 = R.length;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
