package com.sakthi.hiring.thoughtworks;

public class RestHandler
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			RestApiHandler restApiHandler = new RestApiHandler();
			restApiHandler.getUsers();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

