package com.sakthi.datastructure.stack;

public class StackHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleStack stack = new SimpleStack(5);
		stack.push(10);
		stack.push(1);
		stack.push(20);
		stack.push(30);
		stack.push(15);
		stack.push(200);
		System.out.println("capcity=" + stack.getCapacity());
		System.out.println(stack);
		System.out.println(stack.peep());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.peep());
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		stack.push(4);
		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack);
	}

}
