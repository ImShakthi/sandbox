package com.sakthi.hackerearth.hiring.gapInc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GapIncHandler
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TreeAndSpecialNode treeAndSplNode = new TreeAndSpecialNode();
		treeAndSplNode.init();
	}
	
}

class TreeAndSpecialNode
{
	int count = 0;
	private int[] values;
	private List<Integer> tree[];
	
	public void init()
	{
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(System.in);
			// Total number of test cases
			int n = scanner.nextInt();
			values = new int[n + 1];
			tree = new LinkedList[n + 1];
			boolean[] visited = new boolean[1000000 + 1];
			for (int index = 1; index <= n; index++)
			{
				values[index] = scanner.nextInt();
				tree[index] = new LinkedList<Integer>();
				// visited[index] = false;
			}
			
			int parent, child;
			for (int index = 1; index < n; index++)
			{
				parent = scanner.nextInt();
				child = scanner.nextInt();
				
				List<Integer> children = tree[parent];
				if (children == null)
				{
					children = new LinkedList<Integer>();
				}
				children.add(child);
				
				tree[parent] = children;
			}
			// printTree();
			recur(1, visited);
			System.out.println(" count= " + count);
		}
		catch (Exception e)
		{
			System.err.println("error in Tree and special init due to " + e);
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
		}
	}
	
	private void printTree()
	{
		for (int index = 1; index < tree.length; index++)
		{
			System.out.print(index + " > [" + values[index] + "] > [");
			for (Integer i : tree[index])
			{
				System.out.print(i + ",");
			}
			System.out.println("] ");
		}
	}
	
	private void recur(final int index, final boolean[] visited)
	{
		if (visited[values[index]])
		{
			return;
		}
		else
		{
			count++;
			visited[values[index]] = true;
			if (tree[index].size() != 0)
			{
				for (int i = 0; i < tree[index].size(); i++)
				{
					recur(tree[index].get(i), visited);
				}
			}
			visited[values[index]] = false;
		}
	}
	
}