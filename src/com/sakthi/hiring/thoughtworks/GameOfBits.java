package com.sakthi.hiring.thoughtworks;

import java.util.Scanner;

public class GameOfBits {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			GameOfBits gameOfBits = new GameOfBits();

			scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			char[] binaryArr;
			int finalNo;

			int noOfPlayer = Player.values().length;
			for (int i = 1; i <= n; i++) {
				int no = scanner.nextInt();

				// Convert no into binary no in char array
				binaryArr = gameOfBits.getBinary(no);

				// Final no after toggling bits
				finalNo = gameOfBits.getFinalNo(binaryArr);

				boolean won = gameOfBits.isWinningNo(no, finalNo);

				int winnerIndex = 0;
				if (won) {
					winnerIndex = binaryArr.length % noOfPlayer;
				} else {
					winnerIndex = (binaryArr.length + 1) % noOfPlayer;
				}
				System.out.println(Player.values()[winnerIndex]);

			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/**
	 * Method to check the given no is winning no, is it eqal or adjacent
	 * 
	 * @param n
	 *            no
	 * @param res
	 *            result
	 * @return is winning no
	 */
	private boolean isWinningNo(final int n, final int res) {
		boolean isWinningNo = false;
		if ((res >= (n - 1)) && ((n + 1) <= res)) {
			isWinningNo = true;
		}
		return isWinningNo;
	}

	/**
	 * Method to toggle the given bit
	 * 
	 * @param ch
	 *            bit to be toggled
	 * @return toggled bit
	 */
	private char toggle(final char ch) {
		return (ch == '0' ? '1' : '0');
	}

	/**
	 * 
	 * @param binaryArr
	 * @return
	 */
	private int getFinalNo(final char[] binaryArr) {

		int temp_index;
		for (int index = 0; index < binaryArr.length; index++) {
			char currentBit = binaryArr[index];
			binaryArr[index] = toggle(currentBit);

			temp_index = index - 1;
			if (((index) > 0) && (binaryArr[temp_index] == currentBit)) {
				binaryArr[temp_index] = toggle(binaryArr[temp_index]);
			}

			temp_index = index + 1;
			if (((temp_index) < binaryArr.length) && (binaryArr[temp_index] == currentBit)) {
				binaryArr[temp_index] = toggle(binaryArr[temp_index]);
			}
		}
		return Integer.parseInt(String.valueOf(binaryArr), 2);
	}

	/**
	 * Convert the integer into char array
	 * 
	 * @param n
	 *            Input no
	 * @return char array
	 */
	private char[] getBinary(final int n) {
		int no = n;
		String binary = "";
		while (no > 0) {
			binary = (no % 2) + binary;
			no = no / 2;
		}
		// System.out.println("binary=" + binary);
		return binary.toCharArray();
	}

	/**
	 * Player details
	 */
	enum Player {
		X, Y;
	}
}
