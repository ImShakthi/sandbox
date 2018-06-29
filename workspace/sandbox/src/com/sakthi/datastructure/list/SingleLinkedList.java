package com.sakthi.datastructure.list;

class SingleLinkedList {
	private SingleNode head = null;

	public SingleLinkedList() {

	}

	public SingleLinkedList(final SingleNode headArg) {
		this.head = headArg;
	}

	public int size() {
		int size = 0;
		SingleNode temp = this.head;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	public int get(final int index) throws Exception {
		int data = 0;
		int position = 0;
		boolean indexFound = false;
		SingleNode temp = this.head;
		while (temp != null && position <= index) {
			if (position == index) {
				data = temp.getData();
				indexFound = true;
				break;
			}
			position++;
			temp = temp.getNext();
		}
		if (!indexFound) {
			throw new Exception("Index out of bound.");
		}
		return data;
	}

	public boolean add(final int data) {
		try {
			if (this.head == null) {
				this.head = new SingleNode();
				this.head.setData(data);
				this.head.setNext(null);
				return true;
			} else {
				SingleNode temp = head;
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				SingleNode newNode = new SingleNode();
				newNode.setData(data);
				newNode.setNext(null);

				temp.setNext(newNode);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	public boolean add(final int position, final int data) {
		int local_position = 0;
		if (position < 0) {
			System.err.println("Invalid position " + position);
			return false;
		} else {
			boolean validPosition = false;

			SingleNode newNode = new SingleNode();
			newNode.setData(data);

			SingleNode temp = this.head;
			if (position == 0) {
				validPosition = true;
				newNode.setNext(temp);
				this.head = newNode;
			} else {
				SingleNode prev = null;
				while (temp != null) {
					prev = temp;
					temp = temp.getNext();
					local_position++;

					if (local_position == position) {
						validPosition = true;
						break;
					}
				}
				if (validPosition) {
					prev.setNext(newNode);
					newNode.setNext(temp);
				}
			}

			if (!validPosition) {
				System.out.println("Index is ot of bond - " + position);
			}
		}
		return true;
	}

	public void removeAll() {
		SingleNode node = this.head;

		while (node != null) {
			System.out.println(node.getData());
			SingleNode temp = node;
			temp = null;
			node = node.getNext();
		}
		this.head = null;
	}

	public void remove(final int data) {
		boolean elementFound = false;
		SingleNode prev = this.head;
		SingleNode temp = this.head;
		while (temp != null) {
			if (temp.getData() == data) {
				elementFound = true;
				break;
			}
			prev = temp;
			temp = temp.getNext();
		}
		if (elementFound) {
			if (this.head != temp) {
				prev.setNext(temp.getNext());
				// Free the memory space
				temp = null;
			} else {
				if (temp.getNext() == null) {
					this.head = null;
				} else {
					this.head = temp.getNext();
					temp = null;
				}
			}
			System.out.println("Data " + data + " is removed.");
		} else {
			System.out.println("Data " + data + " is not present in the list.");
		}
	}

	public SingleNode find(final int data) {
		SingleNode temp = this.head;
		while (temp != null) {
			if (temp.getData() == data) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	public Integer findAtN(final int position) {
		Integer nodeData = null;
		try {
			SingleNode temp_node = head;
			int index = 0;
			while (temp_node != null) {
				temp_node = temp_node.getNext();
				index++;
			}

			if (position <= index) {
				temp_node = head;
				int stopper = index - position;
				index = 0;
				do {
					if (temp_node != null) {
						if (stopper == index) {
							nodeData = temp_node.getData();
						}
					} else {
						throw new Exception("ot of range.");
					}
					index++;
					temp_node = temp_node.getNext();
				} while (temp_node != null);
			} else {
				throw new Exception("Fewer nos of nodes in the list.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodeData;
	}

	public String toString() {
		String displayStr = "";
		if (this.head != null) {
			SingleNode temp = head;
			while (temp != null) {
				displayStr += temp.getData() + " ";
				temp = temp.getNext();
			}
		} else {
			displayStr = "List is empty.";
		}
		return displayStr;
	}
}

class SingleNode {
	private int data;
	private SingleNode next;

	public int getData() {
		return data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public SingleNode getNext() {
		return next;
	}

	public void setNext(final SingleNode next) {
		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}