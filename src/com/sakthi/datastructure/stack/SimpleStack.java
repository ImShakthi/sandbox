package com.sakthi.datastructure.stack;

import java.util.Arrays;

public class SimpleStack {
	private final static int DEF_CAPACITY = 10;
	private int top = -1;
	private int capacity = 0;
	private int[] array;

	public SimpleStack() {
		this.array = new int[DEF_CAPACITY];
		this.capacity = DEF_CAPACITY;
	}

	public SimpleStack(final int size) {
		this.array = new int[size];
		this.capacity = size;
	}

	public boolean isEmpty() {
		return (this.top == -1);
	}

	public boolean isFull() {
		return (this.top == this.capacity - 1);
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void push(final int number) {
		if (isFull()) {
			System.out.println("Stack overflow.");
			return;
		}
		this.top++;
		this.array[this.top] = number;
	}

	public int pop() {
		int number = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow.");
			return number;
		}
		return this.array[this.top--];
	}

	public int peep() {
		int number = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow.");
			return number;
		}
		return this.array[this.top];
	}

	private int[] getArray() {
		return this.array;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.getArray());
	}

}
