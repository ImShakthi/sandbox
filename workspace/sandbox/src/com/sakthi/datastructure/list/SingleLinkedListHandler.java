package com.sakthi.datastructure.list;

import java.util.Scanner;

public class SingleLinkedListHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedListHandler singleLinkedList = new SingleLinkedListHandler();
		SingleLinkedList list = singleLinkedList.init();
		System.out.println(list.findAtN(9));
	}

	

	public SingleLinkedList init() {
		SingleLinkedList list = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			list = new SingleLinkedList();
			System.out.println(list.toString());
			list.add(10);
			list.add(11);
			list.add(12);
			list.add(13);
			list.add(0, 1);
			list.add(2, 5);
			System.out.println(list.toString());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return list;
	}
}
