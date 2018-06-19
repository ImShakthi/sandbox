package com.sakthi.hiring.thoughtworks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiHandler
{
	private final static String HTTP = "http";
	private final static String COLON = ":";
	private final static String SLASH = "/";
	private final static String SERVER_IP = "localhost";
	private final static String SERVER_PORT = "8080";
	
	public void getUsers()
	{
		HttpURLConnection connnection = null;
		try
		{
			String urlStr = getServerURL() + "/api/users";
			System.out.println(urlStr);
			URL url = new URL(urlStr);
			connnection = (HttpURLConnection) url.openConnection();
			connnection.setRequestMethod("GET");
			connnection.setRequestProperty("Accept", "application/xml");
			
			System.out.println(connnection.getResponseCode());
			if (connnection.getResponseCode() != 200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + connnection.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((connnection.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null)
			{
				System.out.println(output);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connnection != null)
			{
				connnection.disconnect();
			}
		}
	}
	
	public String getServerURL()
	{
		return HTTP + COLON + SLASH + SLASH + SERVER_IP + COLON + SERVER_PORT;
	}
}
