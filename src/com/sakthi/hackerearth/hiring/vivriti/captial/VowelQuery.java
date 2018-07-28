package com.sakthi.hackerearth.hiring.vivriti.captial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelQuery {

	public void init() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			String vowels = "aeiou";
			Integer n = scanner.nextInt();
			Integer[] val = new Integer[n];
			for (int index = 0; index < n; index++) {
				val[index] = scanner.nextInt();
			}
			// System.out.println("inpt=" + input + ", n=" + n + ", Val=" +
			// val);
			String xString = frameVowelStr(input, val);

			char[] xChars = xString.toCharArray();
			Long q = scanner.nextLong();
			for (int index = 0; index < q; index++) {
				int qIndex = scanner.nextInt() - 1;
				if (qIndex < xChars.length) {
					if (vowels.contains(xChars[qIndex] + "")) {
						System.out.println(xChars[qIndex]);
					} else {
						System.out.println(-1);
					}
				} else {
					System.out.println(-1);
				}
			}

		} catch (Exception e) {
			System.err.println("Error in VowelQuery init :: " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private String frameVowelStr(final String input, final Integer[] val) {
		String xString = "";
		int pos;
		int start;
		int end;
		for (int index = 0; index < val.length; index++) {
			pos = Math.abs(val[index]);
			if (val[index] >= 0) {
				start = 0;
				end = pos + 1;
			} else {
				start = pos;
				end = input.length();
			}
			xString = xString + input.substring(start, end);
		}
		// System.out.println(">>>>>>>>> " + xString);
		return xString;
	}
}
