package com.sakthi.datastructure.recursion;

public class KString
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		KString kString = new KString();
		String str = "abc";
		char[] chars = str.toCharArray();
		kString.generate(chars.length, str.toCharArray(), chars);
	}
	
	private void generate(final int n, final char[] chars, final char[] ch)
	{
		if (n < 1)
		{
			System.out.println(chars);
		}
		else
		{
			for (int i = 0; i < chars.length; i++)
			{
				chars[n - 1] = ch[i];//Character.forDigit(i, 10);
				generate(n-1, chars, ch);
			}
		}
	}
}
