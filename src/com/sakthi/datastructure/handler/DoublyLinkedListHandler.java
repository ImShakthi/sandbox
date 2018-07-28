package com.sakthi.datastructure.handler;

import com.sakthi.datastructure.list.DoublyLinkedList;

public class DoublyLinkedListHandler
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			DoublyLinkedList list = new DoublyLinkedList();

			System.out.println("Doubly Linked List");
			list.add(10);
//			list.add(20);
//			list.add(30);
			list.add(1, 23);
			System.out.println(list.print());
			System.out.println(list.getNodeAtIndex(3));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

