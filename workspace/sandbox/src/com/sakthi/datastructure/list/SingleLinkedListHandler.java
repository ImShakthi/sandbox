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
			 System.out.println("Size=" + list.size());
			 list.add(12);
			 list.add(13);
			list.add(0, 1);
			// list.add(2, 5);
			System.out.println("Size=" + list.size());
			list.add(5, 1810);
			System.out.println(list.toString());
			list.remove(13);
			System.out.println("Size=" + list.size());
			System.out.println(list.toString());
			list.remove(1810);
			System.out.println("Size=" + list.size());
			System.out.println(list.toString());
			list.remove(1);
			System.out.println(list.toString());
			list.remove(1);
			System.out.println(list.toString());
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

class SingleLinkedList
{
	private Node head = null;
	
	public SingleLinkedList()
	{
		
	}

	public SingleLinkedList(final Node headArg)
	{
		this.head = headArg;
	}
	
	public int size()
	{
		int size = 0;
		Node temp = this.head;
		while (temp != null)
		{
			size++;
			temp = temp.getNext();
		}
		return size;
	}
	
	public boolean add(final int data)
	{
		try
		{
			if (this.head == null)
			{
				this.head = new Node();
				this.head.setData(data);
				this.head.setNext(null);
				return true;
			}
			else
			{
				Node temp = head;
				while (temp.getNext() != null)
				{
					temp = temp.getNext();
				}
				Node newNode = new Node();
				newNode.setData(data);
				newNode.setNext(null);
				
				temp.setNext(newNode);
				return true;
			}
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
		return false;
	}
	
	public boolean add(final int position, final int data)
	{
		int local_position = 0;
		if (position < 0)
		{
			System.err.println("Invalid position " + position);
			return false;
		}
		else
		{
			boolean validPosition = false;
			
			Node newNode = new Node();
			newNode.setData(data);
			
			Node temp = this.head;
			if (position == 0)
			{
				validPosition = true;
				newNode.setNext(temp);
				this.head = newNode;
			}
			else
			{
				Node prev = null;
				while (temp != null)
				{
					prev = temp;
					temp = temp.getNext();
					local_position++;
					
					if (local_position == position)
					{
						validPosition = true;
						break;
					}
				}
				if (validPosition)
				{
					prev.setNext(newNode);
					newNode.setNext(temp);
				}
			}
			
			if (!validPosition)
			{
				System.out.println("Index is ot of bond - " + position);
			}
		}
		return true;
	}
	
	public void remove(final int data)
	{
		boolean elementFound = false;
		Node prev = this.head;
		Node temp = this.head;
		while (temp != null)
		{
			if (temp.getData() == data)
			{
				elementFound = true;
				break;
			}
			prev = temp;
			temp = temp.getNext();
		}
		if (elementFound)
		{
			if (this.head != temp)
			{
				prev.setNext(temp.getNext());
			}
			else
			{
				if (temp.getNext() == null)
				{
					this.head = null;
				}
				else
				{
					this.head = temp.getNext();
				}
			}
			System.out.println("Data " + data + " is removed.");
		}
		else
		{
			System.out.println("Data " + data + " is not present in the list.");
		}
	}
	
	public Node find(final int data)
	{
		Node temp = this.head;
		while (temp != null)
		{
			if (temp.getData() == data)
			{
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	public String toString()
	{
		String displayStr = "";
		if (this.head != null)
		{
			Node temp = head;
			while (temp != null)
			{
				displayStr += temp.getData() + " ";
				temp = temp.getNext();
			}
		}
		else
		{
			displayStr = "List is empty.";
		}
		return displayStr;
	}
}

class Node
{
	private int data;
	private Node next;
	
	public int getData()
	{
		return data;
	}
	
	public void setData(final int data)
	{
		this.data = data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(final Node next)
	{
		this.next = next;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}