package com.sakthi.sandbox;

import java.util.Map;

public class SampleKlass {

	public static void main(String[] args) {
		SampleKlass sample = new SampleKlass();
		sample.binary();
		Map<Integer, Integer> map = null;
		map.put(1, 1);
		
	}

	public void binary() {
		int n = 4;
		int m = (n * 2) - 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(getMax(Math.abs(n - i - 1), Math.abs(n - j - 1)) + 1);
			}
			System.out.println();
		}
		// Long n = Long.MAX_VALUE;
		// while (n > 0) {
		// System.out.print(n % 2);
		// n = n / 2;
		// }
	}

	private int getMax(final int a, final int b) {
		// System.out.println("a=" + a + ",b=" + b);
		if (a >= b) {
			return a;
		}
		return b;
	}
}
