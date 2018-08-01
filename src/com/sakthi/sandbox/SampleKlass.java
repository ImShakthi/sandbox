package com.sakthi.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SampleKlass {

	transient Set<Integer> xx;

	public static void main(String[] args) {
		SampleKlass sample = new SampleKlass();
		sample.sample();
	}

	public void sample() {
		List<Integer> list = new ArrayList<>();
		list.add(new Integer(10));
//		list.add(new Integer(10));
//		list.add(4);
//		list.add(4);
//		list.add(3);
//		list.add(3);

		System.out.println(list);

		System.out.println(list.remove(new Integer(10)));
		System.out.println(list);

		Set<Integer> set = new HashSet<>();
		set.add(null);
		set.add(1);
		System.out.println(set);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(5);
		map.put(10, null);
		System.out.println(map.get(18));
		// map.forEach(System.out.println());
		System.out.println(">>>>>>>>>>>> " + list);
		try {
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println((int) iterator.next());
//				list.add(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * <code>
	 * 4444444
	 * 4333334
	 * 4322234
	 * 4321234
	 * 4322234
	 * 4333334
	 * 4444444
	 * </code>
	 */
	public void printPattern() {
		int n = 4;
		int m = (n * 2) - 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(getMax(Math.abs(n - i - 1), Math.abs(n - j - 1)) + 1);
			}
			System.out.println();
		}
	}

	private int getMax(final int a, final int b) {
		if (a > b) {
			return a;
		}
		return b;
	}
}
