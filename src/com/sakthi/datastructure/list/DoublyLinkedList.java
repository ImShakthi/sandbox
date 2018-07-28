package com.sakthi.datastructure.list;

public class DoublyLinkedList {
	private DoublyNode head = null;

	public void add(final int nodeArg) {
		DoublyNode temp = this.head;
		DoublyNode newNode = new DoublyNode();
		newNode.setData(nodeArg);
		if (temp == null) {
			newNode.setPrev(null);
			newNode.setNext(null);
			this.head = newNode;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setPrev(temp);
			newNode.setNext(null);
		}
	}

	public void add(final int index, final int dataArg) {
		int position = 0;
		boolean indexFound = false;
		DoublyNode temp = this.head;
		DoublyNode newNode = new DoublyNode();
		newNode.setData(dataArg);

		if (index == 0) {
			newNode.setPrev(null);
			newNode.setNext(temp);

			temp.setPrev(newNode);
			this.head = newNode;
		} else if (temp == null) {
			newNode.setPrev(null);
			newNode.setNext(null);
			this.head = newNode;
			System.out.println("Inserted at head");
		} else {
			while (temp != null && position <= index) {
				System.out.println(">>> index=" + index + ", position=" + position);
				if (index == position) {
					indexFound = true;
					System.out.println(" index found " + temp.getData());
					break;
				}
				position++;
				temp = temp.getNext();
			}
			if (indexFound) {
				DoublyNode prevNode = temp != null ? temp.getPrev() : temp;
				DoublyNode nextNode = temp;
				// System.out.println("prevNode=" + prevNode != null ?
				// prevNode.getNode() : prevNode + ", nextNode=" +
				// nextNode.getNode());
				newNode.setPrev(prevNode);
				newNode.setNext(nextNode);

				if (prevNode != null) {
					prevNode.setNext(newNode);
				} else {

				}
				nextNode.setPrev(newNode);
				System.out.println("Inserted at index " + index);
			} else {
				System.out.println("Index Out of bound - " + index);
			}
		}
	}

	public String getNodeAtIndex(final int index) {
		String nodes = "";
		int count = 0;
		boolean indexAvail = false;
		DoublyNode temp = this.head;
		while (temp != null) {
			if (count == index) {
				indexAvail = true;
				break;
			}
			count++;
			temp = temp.getNext();
		}
		if (indexAvail) {
			nodes = "prev=";
			if (temp.getPrev() != null) {
				nodes += temp.getPrev().getData();
			} else {
				nodes = "null";
			}
			nodes += ", ";

			nodes += "data=" + temp.getData();
			nodes += ", ";
			nodes += "next=";
			if (temp.getNext() != null) {
				nodes += temp.getNext().getData();
			} else {
				nodes += "null";
			}
		} else {
			nodes = "Invalid index.";
		}
		return nodes;
	}

	public String print() {
		String nodes = "";
		DoublyNode temp = this.head;
		while (temp != null) {
			nodes += temp.getData() + ", ";
			temp = temp.getNext();
		}
		return nodes;
	}
}

class DoublyNode {
	private int data;
	private DoublyNode prev;
	private DoublyNode next;

	/**
	 * @return the node
	 */
	public final int getData() {
		return data;
	}

	/**
	 * @param node
	 *            the node to set
	 */
	public final void setData(int node) {
		this.data = node;
	}

	/**
	 * @return the prev
	 */
	public final DoublyNode getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 *            the prev to set
	 */
	public final void setPrev(DoublyNode prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public final DoublyNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public final void setNext(DoublyNode next) {
		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Method for Node [node=" + data + "]";
	}
}
