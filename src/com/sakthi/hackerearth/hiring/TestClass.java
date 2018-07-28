package com.sakthi.hackerearth.hiring;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
	public static void main(String args[]) throws Exception {
		// Write your code here
		OldAndColdNumber oldAndCold = new OldAndColdNumber();
		oldAndCold.init();

	}
}

class OldAndColdNumber {

	public void init() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int T;
			int N;
			int Q;

			int l;
			int r;

			long[] array;
			boolean[] isOldArr;
			// System.out.println("~Old and Cold number~");

			// System.out.println("Enter the number of test cases T = ");
			T = scanner.nextInt();

			for (int i = 0; i < T; i++) {
				// System.out.println("Enter array size N = ");
				N = scanner.nextInt();
				array = new long[N];
				isOldArr = new boolean[N];

				for (int index = 0; index < N; index++) {
					array[index] = scanner.nextLong();
					isOldArr[index] = isOld(array[index]);
				}

				// System.out.println("Enter queries Q = ");
				Q = scanner.nextInt();
				int[] result = new int[Q];
				for (int queryIndex = 0; queryIndex < Q; queryIndex++) {
					l = scanner.nextInt();
					r = scanner.nextInt();

					// getMinimalStep(isOldArr, l, r, queryIndex);

					final CountDownLatch latch = new CountDownLatch(1);
					Thread minimalThread = new MinimalStepper(isOldArr, l, r, queryIndex) {
						@Override
						public void run() {

							int coldCount = 0;
							int oldCount = 0;
							for (int index = start - 1; index < r; index++) {
								if (isOldArr[index]) {
									oldCount++;
								} else {
									coldCount++;
								}
							}
							if (coldCount <= oldCount) {
								result[queryIndex] = 0;
								latch.countDown();
							} else {
								int n = coldCount - oldCount;
								result[queryIndex] = (n / 2) + (n % 2 == 0 ? 0 : 1);
								latch.countDown();
							}
						}
					};
					minimalThread.start();
					latch.await();
				}

				for (int index = 0; index < result.length; index++) {
					System.out.println(result[index]);
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

	private void getMinimalStep(final boolean[] isOldArr, final int l, final int r) {
		int coldCount = 0;
		int oldCount = 0;
		for (int index = l - 1; index < r; index++) {
			if (isOldArr[index]) {
				oldCount++;
			} else {
				coldCount++;
			}
		}
		if (coldCount <= oldCount) {
			System.out.println(0);
			// return 0;
		} else {
			int n = coldCount - oldCount;
			// return ((n / 2) + (n % 2 == 0 ? 0 : 1));
			System.out.println((n / 2) + (n % 2 == 0 ? 0 : 1));
		}
	}

	private boolean isOld(final long val) {
		long oddCount = getOddNumberCount(val);
		return (val % oddCount == 0);
	}

	private long getOddNumberCount(final long valueX) {
		return ((valueX / 2) + (valueX % 2));
	}
}

class MinimalStepper extends Thread {

	public boolean[] isOldArr;
	public int start;
	public int r;
	public int queryIndex;

	public MinimalStepper(final boolean[] isOldArrArg, final int lArg, final int rArg, final int queryIndex) {
		this.isOldArr = isOldArrArg;
		this.start = lArg;
		this.r = rArg;
		this.queryIndex = queryIndex;
	}

	public void run() {
		int coldCount = 0;
		int oldCount = 0;
		for (int index = start - 1; index < r; index++) {
			if (isOldArr[index]) {
				oldCount++;
			} else {
				coldCount++;
			}
		}
		synchronized (isOldArr) {
			if (coldCount <= oldCount) {
				System.out.println(0);
				// return 0;
			} else {
				int n = coldCount - oldCount;
				// return ((n / 2) + (n % 2 == 0 ? 0 : 1));
				System.out.println((n / 2) + (n % 2 == 0 ? 0 : 1));
			}
		}
	}
}