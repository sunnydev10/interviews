package org.something;

import java.util.stream.IntStream;

public class BubbleSort {
	public static void sortArray(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int k = array[j];
					array[j] = array[j + 1];
					array[j + 1] = k;
				}
			}
		}
		
	}

	public static void bubbleSort(Integer[] arr) {
		int n = arr.length;
		IntStream.range(0, n - 1)
		.flatMap(i -> IntStream.range(1, n - i))
		.forEach(j -> {
			if (arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		});
	}
}
