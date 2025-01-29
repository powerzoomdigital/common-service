package com.pzip.common.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://newaikyadb.mysql.database.azure.com/aikyadb"; // Replace with your database URL
        String user = "aikya"; // Replace with your username
        String password = "Champi0n335577"; // Replace with your password

        try {
            // Use the correct driver for your version
            Class.forName("com.mysql.cj.jdbc.Driver"); // For Connector/J 8.0+
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
			// Retrieving the data
			ResultSet rs = stmt.executeQuery("Show Databases");
			System.out.println("List of databases: ");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println();
			}
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}