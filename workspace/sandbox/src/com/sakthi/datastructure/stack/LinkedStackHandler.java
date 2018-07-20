package com.sakthi.datastructure.stack;

public class LinkedStackHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack stack = new LinkedStack();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(30);
		System.out.println("size=" + stack.getSize());
		
		System.out.println(stack);
		System.out.println(" POP = " + stack.pop());
		System.out.println(stack);
		System.out.println(" POP = " + stack.pop());
		System.out.println(" POP = " + stack.pop());
		System.out.println(" POP = " + stack.pop());
		System.out.println(" POP = " + stack.pop());
		System.out.println(stack);

		System.out.println("size=" + stack.getSize());
	}

}
