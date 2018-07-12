/**
 * 
 */
package com.sakthi.database.postgres.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sakthivel
 *
 */
public class PostgresHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PostgresHandler handler = new PostgresHandler();
		handler.printTable();
	}

	public boolean printTable() {
		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sampledb", "sakthivel",
					"admin123");

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM test");
			
			if(rs.next()){
				System.out.println(rs.getString(2));
			}
			if (connection != null) {
				rs.close();
				stmt.close();
				connection.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkConnection() {
		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return false;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sampledb", "sakthivel",
					"admin123");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}

		try {
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				connection.close();
				return true;
			} else {
				System.out.println("Failed to make connection!");
				return false;
			}
		} catch (Exception e) {
			System.err.println("Error " + e);
			return false;
		}
	}
}
