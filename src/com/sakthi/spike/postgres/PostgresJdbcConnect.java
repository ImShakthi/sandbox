package com.sakthi.spike.postgres;

import java.sql.*;

public class PostgresJdbcConnect {
  public static void main(String[] args) {
    try (Connection connection =
        DriverManager.getConnection(
            "jdbc:postgresql://ec2-23-23-184-76.compute-1.amazonaws.com:5432/d89qjj04bpelm2", "tuzuryrvzqlvuk", "9ed039d856e08053853bb09bba66badfb1c8bb61bbfe2282c37cd6d11866c327")) {

      System.out.println("Java JDBC PostgreSQL Example");
      // When this class first attempts to establish a connection, it automatically loads any JDBC
      // 4.0 drivers found within
      // the class path. Note that your application must manually load any JDBC drivers prior to
      // version 4.0.
      //			Class.forName("org.postgresql.Driver");

      System.out.println("Connected to PostgreSQL database!");
      Statement statement = connection.createStatement();
      System.out.println("Reading car records...");
      ResultSet resultSet = statement.executeQuery("SELECT * FROM school");
      while (resultSet.next()) {
        System.out.printf(
            "%s  %s%n", resultSet.getString("id"), resultSet.getString("name"));
      }

    } /*catch (ClassNotFoundException e) {
      	System.out.println("PostgreSQL JDBC driver not found.");
      	e.printStackTrace();
      }*/ catch (SQLException e) {
      System.out.println("Connection failure.");
      e.printStackTrace();
    }
  }
}
