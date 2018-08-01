package com.sakthi.datastructure.queue;

public class SimpleQueue {

	public static final int DEFAULT_QUEUE_SIZE = 10;
	private int[] array;
	private int front;
	private int rear;
	private int capacity;

	public SimpleQueue() {
		this(DEFAULT_QUEUE_SIZE);
	}

	public SimpleQueue(final int capacityArg) {
		this.capacity = capacityArg;
		this.array = new int[this.capacity];
		this.front = -1;
		this.rear = -1;
	}

	public int getCapcity() {
		return this.capacity;
	}

	public boolean isEmpty() {
		return this.front == -1;
	}

	public boolean isFull() {
		return ((this.rear + 1) % this.capacity) == this.front;
	}

	public void enQueue(final int element) {
		if (isFull()) {
			System.out.println("Queue full.");
		} else {
			this.rear = (this.rear + 1) % this.capacity;
			array[this.rear] = element;
			if (this.front == -1) {
				this.front = this.rear;
			}
		}
	}

	public int deQueue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			data = this.array[this.front];
			if (this.front == this.rear) {
				this.front = -1;
				this.rear = -1;
			} else {
				this.front = (this.front + 1) % this.capacity;
			}
		}
		return data;
	}

	@Override
	public String toString() {

		System.out.println("front=" + this.front + ", rear=" + this.rear);
		String str = "[";
		for (int index = this.rear; this.front <= index; index--) {
			System.out.println("index=" + index);
			str += this.array[index] + "->";
		}
		str = str.substring(0, str.length() - 2);
		str += "]";
		return str;
	}
}
