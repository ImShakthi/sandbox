package com.sakthi.hackerearth.hiring.wissen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Integer;

public class RectAligner {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L[] = new int[N];
		int R[] = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(tk.nextToken());
			R[i] = Integer.parseInt(tk.nextToken());
		}
		align_rectangles(N, L, R);
		for (int i = 0; i < N; i++) {
			System.out.println(L[i] + " " + R[i]);
		}
	}

	public static void align_rectangles(final int N, final int[] lengthArr, final int[] breadthArr) {
		sort(lengthArr, breadthArr, 0, N - 1);
	}

	/**
	 * <code>
	 * 		int n = lengthArr.length;
			int temp;
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
	
					if (lengthArr[i] > lengthArr[j]) {
						temp = lengthArr[i];
						lengthArr[i] = lengthArr[j];
						lengthArr[j] = temp;
	
						temp = breadthArr[i];
						breadthArr[i] = breadthArr[j];
						breadthArr[j] = temp;
					} else if (lengthArr[i] == lengthArr[j] && breadthArr[i] < breadthArr[j]) {
						temp = breadthArr[i];
						breadthArr[i] = breadthArr[j];
						breadthArr[j] = temp;
					}
				}
			}
	
	 * </code>
	 */
	private static void merge(final int lengthArr[], final int[] breadthArr, final int l, final int m, final int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int lengthLeft[] = new int[n1];
		int lengthRight[] = new int[n2];

		int breadthLeft[] = new int[n1];
		int breadthRight[] = new int[n2];

		for (int i = 0; i < n1; ++i) {
			lengthLeft[i] = lengthArr[l + i];
			breadthLeft[i] = breadthArr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			lengthRight[j] = lengthArr[m + 1 + j];
			breadthRight[j] = breadthArr[m + 1 + j];
		}

		int i = 0, j = 0;

		int k = l;
		System.out.println("Before> i=" + i + ", n1=" + n1 + ", j=" + j + ", n2=" + n2);
		System.out.println(Arrays.toString(lengthArr));
		System.out.println(Arrays.toString(breadthArr));
		while (i < n1 && j < n2) {
			// if (lengthLeft[i] == lengthRight[j]) {
			// if (breadthLeft[i] < breadthRight[j] && i != j) {
			// int temp = breadthLeft[i];
			// breadthLeft[i] = breadthRight[j];
			// breadthRight[j] = temp;
			// }
			// i++;
			// } else
			if (lengthLeft[i] <= lengthRight[j]) {
				lengthArr[k] = lengthLeft[i];
				breadthArr[k] = breadthLeft[i];
				i++;
			} else {
				lengthArr[k] = lengthRight[j];
				breadthArr[k] = breadthRight[j];
				j++;
			}
			k++;
		}

		System.out.println("After> i=" + i + ", n1=" + n1 + ", j=" + j + ", n2=" + n2);
		System.out.println(Arrays.toString(lengthArr));
		System.out.println(Arrays.toString(breadthArr));
		while (i < n1) {
			lengthArr[k] = lengthLeft[i];
			breadthArr[k] = breadthLeft[i];
			i++;
			k++;
		}

		while (j < n2) {
			lengthArr[k] = lengthRight[j];
			breadthArr[k] = breadthRight[j];
			j++;
			k++;
		}
	}

	private static void sort(final int lengthArr[], final int[] breadthArr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(lengthArr, breadthArr, l, m);
			sort(lengthArr, breadthArr, m + 1, r);

			merge(lengthArr, breadthArr, l, m, r);
		}
	}

}
