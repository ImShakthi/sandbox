package com.sakthi.hackerearth.hiring.wissen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OneValue {

	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		init();
	}

	public static void init() {

		Scanner scanner = null;
		try {
			int val;
			short choice;

			scanner = new Scanner(System.in);
			int m = scanner.nextInt();
			for (int index = 0; index < m; index++) {
				choice = scanner.nextShort();
				switch (choice) {
				case 1:
					// INSERT a number
					val = scanner.nextInt();
					add_to_list(val);
					break;
				case 2:
					// Remove a number
					val = scanner.nextInt();
					remove_from_list(val);
					break;
				case 3:
					// Largest, less frequent number
					val = find_least_frequency();
					System.out.println(val);
					break;
				case 4:
					// Largest, less frequent number
					val = find_highest_frequency();
					System.out.println(val);
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	/**
	 * Method to get largest least frequent number
	 * 
	 * @return largest number
	 */
	public static int find_least_frequency() {
		int largestNumber = -1;

		if (!map.isEmpty()) {
			// Max possible of M is 10 power 5
			int leastFreqCount = 100000;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() < leastFreqCount) {
					leastFreqCount = entry.getValue();
					largestNumber = entry.getKey();
				} else if (entry.getValue() == leastFreqCount && largestNumber < entry.getKey()) {
					largestNumber = entry.getKey();
				}
			}
		}
		return largestNumber;
	}

	public static int find_highest_frequency() {
		int smallestNumber = -1;

		if (!map.isEmpty()) {
			int highFreqCount = -1;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > highFreqCount) {
					highFreqCount = entry.getValue();
					smallestNumber = entry.getKey();
				} else if (entry.getValue() == highFreqCount && smallestNumber > entry.getKey()) {
					smallestNumber = entry.getKey();
				}
			}
		}
		return smallestNumber;
	}

	public static void add_to_list(final int val) {
		Integer count = map.get(val);
		if (count == null) {
			count = 0;
		}
		count++;
		map.put(val, count);
	}

	public static boolean remove_from_list(final int val) {
		Integer count = map.get(val);
		if (count != null) {
			count--;
			if (count == 0) {
				map.remove(val);
			} else {
				map.put(val, count);
			}
		}
		return true;
	}
}
