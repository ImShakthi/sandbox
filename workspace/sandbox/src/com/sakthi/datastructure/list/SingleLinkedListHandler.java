package com.sakthi.datastructure.list;

import java.util.Scanner;

public class SingleLinkedListHandler
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SingleLinkedListHandler singleLinkedList = new SingleLinkedListHandler();
		singleLinkedList.init();
	}
	
	public void init()
	{
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(System.in);
			SingleLinkedList list = new SingleLinkedList();
			System.out.println(list.toString());
			list.add(10);
			list.add(11);
			list.add(12);
			list.add(13);
			list.remove(13);
			list.add(0, 1);
			list.add(2, 5);
			list.add(5, 1810);
			list.removeAll();
			System.out.println(list.toString());
			
			int len = list.size();
			for (int index = 0; index < len; index++)
			{
				System.out.println(list.get(index));
			}
			
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
		}
	}
}
