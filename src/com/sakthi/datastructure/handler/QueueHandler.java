package com.sakthi.datastructure.handler;

import com.sakthi.datastructure.queue.SimpleQueue;

public class QueueHandler {

	public static void main(String[] args) {
		SimpleQueue queue = new SimpleQueue(3);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(">> " + queue.getCapcity());
		queue.enQueue(5);
		queue.enQueue(5);
		queue.enQueue(5);
		System.out.println("@@@@");
		System.out.println(queue);
	}

}
