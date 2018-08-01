package com.sakthi.datastructure.tree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public boolean isEmpty() {
		return (this.root == null);
	}

	public void insert(final int data) {
		this.root = this.insert(this.root, data);
	}

	private Node insert(Node node, final int data) {
		// Node temp_node = node;
		if (node == null) {
			node = new Node(data);
			System.out.println("set " + data + "> node " + node);
		} else {
			if (node.getRight() == null) {
				node.setRight(insert(node.getRight(), data));
			} else {
				node.setLeft(insert(node.getLeft(), data));
			}
		}
		return node;
	}

	public boolean contains(final int data) {
		return contains(this.root, data);
	}

	private boolean contains(final Node node, final int data) {
		if (node.getData() == data) {
			return true;
		} else if (node.getLeft() != null) {
			if (contains(node.getLeft(), data)) {
				return true;
			}
		} else if (node.getRight() != null) {
			if (contains(node.getRight(), data)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return getCount(this.root);
	}

	private int getCount(final Node node) {
		if (node == null) {
			return 0;
		} else {
			int count = 1;
			count += getCount(node.getRight());
			count += getCount(node.getLeft());
			return count;
		}
	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(final Node node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + ", ");
			inorder(node.getRight());
		}
	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(final Node node) {
		if (node != null) {
			System.out.print(node.getData() + ", ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(final Node node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.getData() + ", ");
		}
	}

}

class Node {
	private int data;
	private Node left;
	private Node right;

	public Node() {

	}

	public Node(final int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(final Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(final Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}