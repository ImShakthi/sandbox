package com.sakthi.hackerearth.hiring.wissen;

import java.util.Arrays;
import java.util.Comparator;

public class RectAligner2 {

	private final static int LEN_INDEX = 0;
	private final static int BRED_INDEX = 1;

	public static void main(String[] args) {
		// int[][] arr = new int[5][5];
		int[][] arr = { { 2, 3 }, { 1, 2 }, { 1, 3 } };

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(final int[] arr1, final int[] arr2) {
				if (arr1[LEN_INDEX] > arr2[LEN_INDEX]) {
					return 1;
				} else if (arr1[LEN_INDEX] == arr2[LEN_INDEX]) {
					if (arr1[BRED_INDEX] < arr2[BRED_INDEX]) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][LEN_INDEX] + " " + arr[i][BRED_INDEX]);
		}
	}

}
