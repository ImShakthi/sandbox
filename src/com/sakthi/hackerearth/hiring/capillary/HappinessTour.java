package com.sakthi.hackerearth.hiring.capillary;

import java.util.Scanner;

public class HappinessTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappinessTour happinessTour = new HappinessTour();
		happinessTour.init();
	}

	public void init() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int T;
			int N;
			int M;
			long[] happiness;
			int[] uCity;
			int[] vCity;

			T = scanner.nextInt();
			for (int testIndex = 0; testIndex < T; testIndex++) {
				N = scanner.nextInt();
				happiness = new long[N];
				for (int index = 0; index < N; index++) {
					happiness[index] = scanner.nextLong();
				}

				M = scanner.nextInt();
				uCity = new int[M];
				vCity = new int[M];
				for (int index = 0; index < M; index++) {
					uCity[index] = scanner.nextInt();
				}
				for (int index = 0; index < M; index++) {
					vCity[index] = scanner.nextInt();
				}

				long maxHappiness = happiness[uCity[0] - 1] + happiness[vCity[0] - 1];
				for (int index = 0; index < M; index++) {
					long sum = happiness[uCity[index] - 1] + happiness[vCity[index] - 1];
					if (sum > maxHappiness) {
						maxHappiness = sum;
					}
				}
				System.out.println(maxHappiness);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
