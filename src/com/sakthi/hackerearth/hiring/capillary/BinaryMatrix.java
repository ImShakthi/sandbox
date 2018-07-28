package com.sakthi.hackerearth.hiring.capillary;

import java.math.BigInteger;
import java.util.Scanner;

public class BinaryMatrix {

	public static void main(String[] args) {

		BinaryMatrix binary = new BinaryMatrix();
		binary.init();

	}

	public void init() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);

			System.out.println("~Binary Matrix~" + Long.MAX_VALUE);
			int n;
			int m;

			n = scanner.nextInt();
			m = scanner.nextInt();

			int bigIndex = 1;
			BigInteger bigNo = BigInteger.ZERO;
			BigInteger inpt = BigInteger.ZERO;
			for (int index = 0; index < n; index++) {
				inpt = scanner.nextBigInteger();
				
				if (inpt.compareTo(bigNo) == 1) {
					bigIndex = index + 1;
					bigNo = inpt;
				}
			}
			System.out.println(bigIndex);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
