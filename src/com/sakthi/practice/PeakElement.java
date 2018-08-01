package com.sakthi.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PeakElement {

	public static void main(String[] args) {
		PeakElement peakElement = new PeakElement();
		peakElement.init();
	}

	public void init() {
		try {
			int arr[] = { 1, 3, 20, 4, 1, 0, 23, 41, 34 };
			int n = arr.length;
			System.out.println(findPeak(arr, n));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	private int findPeakUtil(int arr[], int low, int high, int n) {
		// Find index of middle element
		int mid = (low + high) / 2;

		System.out.println(">> low=" + low + ", mid=" + mid + ", high=" + high);
		// Compare middle element with its neighbours (if neighbours
		// exist)
		if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
			return arr[mid];
		}

		// If middle element is not peak and its left neighbor is
		// greater than it,then left half must have a peak element
		else if (mid > 0 && arr[mid - 1] > arr[mid]) {
			return findPeakUtil(arr, low, (mid - 1), n);
		}

		// If middle element is not peak and its right neighbor
		// is greater than it, then right half must have a peak
		// element
		else {
			return findPeakUtil(arr, (mid + 1), high, n);
		}
	}

	// A wrapper over recursive function findPeakUtil()
	private int findPeak(int arr[], int n) {
		return findPeakUtil(arr, 0, n - 1, n);
	}
}
