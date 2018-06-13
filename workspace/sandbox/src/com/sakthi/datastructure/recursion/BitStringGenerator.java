package com.sakthi.datastructure.recursion;

public class BitStringGenerator
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		BitStringGenerator bitStringGenerator = new BitStringGenerator();
		String str = "12";
		char[] string = str.toCharArray();
		bitStringGenerator.generate(string.length, string);
	}
	
	private void generate(final int n, final char[] string)
	{
		if (n < 1)
		{
			System.out.println(string);
		}
		else
		{
			string[n - 1] = '0';
			generate(n - 1, string);
			string[n - 1] = '1';
			generate(n - 1, string);
		}
	}
}
