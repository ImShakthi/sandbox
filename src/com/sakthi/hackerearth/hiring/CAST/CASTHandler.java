/**
 * 
 */
package com.sakthi.hackerearth.hiring.CAST;

import java.util.Scanner;

/**
 * @author sakthivel
 *
 */
public class CASTHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CASTHandler handler = new CASTHandler();
		handler.perPendicularLine();
	}

	public void perPendicularLine() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int n = scanner.nextInt();

			Long x1, y1;
			Long x2, y2;
			Long x3, y3;
			Long x4, y4;
			Long m1 = (long) 1, m2 = (long) 1;
			boolean invalid = false;
			for (int index = 0; index < n; index++) {
				try {
					x1 = scanner.nextLong();
					y1 = scanner.nextLong();
					x2 = scanner.nextLong();
					y2 = scanner.nextLong();

					if (x1 != x2 && y1 != y2) {
						m1 = getSlope(x1, y1, x2, y2);
					} else {
						invalid = true;
					}

					x3 = scanner.nextLong();
					y3 = scanner.nextLong();
					x4 = scanner.nextLong();
					y4 = scanner.nextLong();
					if (x3 != x4 && y3 != y4) {
						m2 = getSlope(x3, y3, x4, y4);
					} else {
						invalid = true;
					}

					if (m1 == -(1 / m2)) {
						System.out.println("YES");
					} else if (invalid) {
						System.out.println("INVALID");
						invalid = false;
					} else {
						System.out.println("NO");
					}
				} catch (Exception e) {
					System.out.println("INVALID");
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

	private Long getSlope(Long x1, Long y1, Long x2, Long y2) {
		return (y2 - y1) / (x2 - x1);
	}
}
