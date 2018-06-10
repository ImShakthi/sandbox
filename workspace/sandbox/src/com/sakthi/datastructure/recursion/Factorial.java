package com.sakthi.datastructure.recursion;

import java.util.Scanner;

public class Factorial
{
	public static void main(final String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("factorial");
		Scanner scan = null;
		try
		{
			scan = new Scanner(System.in);
			
			Factorial factorial = new Factorial();
			System.out.println("Enter the N :: ");
			int n = scan.nextInt();
			System.out.println(factorial.fact(n));
		}
		catch (Exception e)
		{
			System.err.println("Error due to " + e);
		}
		finally
		{
			if (scan != null)
			{
				scan.close();
			}
		}
	}
	
	private int fact(final int n)
	{
		if (n < 2)
		{
			return 1;
		}
		return n * fact(n - 1);
	}
}
