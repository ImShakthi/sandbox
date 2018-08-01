package com.sakthi.datastructure.sorting;

/* Java program for Merge Sort */
public class MergeSort {
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}

/**
 * <code>
	private static void merge(final int lengthArr[],final int[] breadthArr, final int l, final int m, final int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L1[] = new int[n1];
		int R1[] = new int[n2];

		int L2[] = new int[n1];
		int R2[] = new int[n2];

		for (int i = 0; i < n1; ++i){
			L1[i] = lengthArr[l + i];
			L2[i] = breadthArr[l + i];
		}
		for (int j = 0; j < n2; ++j){
			R1[j] = lengthArr[m + 1 + j];
			R2[j] = breadthArr[m + 1 + j];
		}

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L1[i] <= R1[j]) {
				lengthArr[k] = L1[i];
				breadthArr[k] = L2[i];
				i++;
			} else {
				lengthArr[k] = R1[j];
				breadthArr[k] = R2[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			lengthArr[k] = L1[i];
			breadthArr[k] = L2[i];
			i++;
			k++;
		}

		while (j < n2) {
			lengthArr[k] = R1[j];
			breadthArr[k] = R2[j];
			j++;
			k++;
		}
	}

	private static void sort(final int lengthArr[],final int[] breadthArr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(lengthArr, breadthArr, l, m);
			sort(lengthArr, breadthArr, m + 1, r);

			merge(lengthArr, breadthArr, l, m, r);
		}
	}

</code>
 */