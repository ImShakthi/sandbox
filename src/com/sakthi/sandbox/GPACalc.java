package com.sakthi.sandbox;

import java.util.Scanner;

public class GPACalc
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scanner = null;
		try
		{
			int n;
			int credit;
			int credits = 0;
			double grade;
			String gradeLetter;
			int gradeCredit = 0;
			
			scanner = new Scanner(System.in);
			System.out.println("Enter the number of subjects :: ");
			n = scanner.nextInt();
			for (int i = 0; i < n; i++)
			{
				System.out.println("enter Credit for subject #" + (i + 1) + " = ");
				credit = scanner.nextInt();
				System.out.println("enter Grade Letter for subject #" + (i + 1) + " = ");
				gradeLetter = scanner.next();
				grade = getGrade(gradeLetter);
				
				double temp = credit * grade;
				gradeCredit += temp;
//				System.out.println("#temp=" + temp + ", gradeCredit=" + gradeCredit);
				// To calculate total credits
				credits += credit;
			}
			System.out.println("#credits=" + credits + ", gradeCredit=" + gradeCredit);
			
			System.out.println("#GPA=" + (double) gradeCredit / credits);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
		}
	}
	
	public static double getGrade(final String gradeLetter)
	{
		double grade;
		switch (gradeLetter.toUpperCase())
		{
		case "O":
			grade = 10.0;
			break;
		case "E":
			grade = 9.5;
			break;
		case "A":
			grade = 9;
			break;
		case "B":
			grade = 8.0;
			break;
		case "C":
			grade = 7.0;
			break;
		case "D":
			grade = 6.0;
			break;
		case "S":
			grade = 5.0;
			break;
		default:
			grade = 0;
			break;
		}
//		System.out.println("gradeLetter=" + gradeLetter + ", grade=" + grade);
		return grade;
	}
}
// 10 4 d 3 c 3 d 4 s 3 b 4 d 6 b 3 c 3 d 3 c