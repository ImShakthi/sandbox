package com.sakthi.datastructure.stack;

public class LinkedStack {

	private Node top = null;

	public boolean isEmpty() {
		if (top == null) {
			System.out.println("Stack underflow.");
			return true;
		}
		return false;
	}

	public void push(final int data) {
		if (top == null) {
			top = new Node();
			top.setData(data);
		} else {
			Node newNode = new Node();
			newNode.setData(data);
			newNode.setNext(top);
			top = newNode;
		}
	}

	public int peep() {
		if (isEmpty()) {
			return -1;
		} else {
			return top.getData();
		}
	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			Node temp = top;
			top = top.getNext();
			return temp.getData();
		}
	}

	public int getSize() {
		int count = 0;
		Node temp = top;
		while (temp != null) {
			temp = temp.getNext();
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		return "LinkedStack [top=" + top + "]";
	}
}

class Node {
	private int data;
	private Node next;

	public final int getData() {
		return data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}