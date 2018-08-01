package com.sakthi.datastructure.handler;

import com.sakthi.datastructure.tree.BinaryTree;

public class BinaryTreeHandler {

	public static void main(String[] args) {
		BinaryTreeHandler binaryTreeHandler = new BinaryTreeHandler();
		binaryTreeHandler.init();
	}

	public void init() {
		BinaryTree binaryTree = new BinaryTree();
		System.out.println(binaryTree.isEmpty());
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		System.out.println(binaryTree.isEmpty());
		binaryTree.preorder();
		System.out.println();
		binaryTree.inorder();
		System.out.println();
		binaryTree.postorder();
		System.out.println(" Size= " + binaryTree.size());
		System.out.println("Contains 10 = " + binaryTree.contains(10));
		System.out.println("Contains 1 = " + binaryTree.contains(1));
	}
}
