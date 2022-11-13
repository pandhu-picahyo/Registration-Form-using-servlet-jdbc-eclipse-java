package com.createtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	// JDBC driver name and database URL
	static final String DB_URL = "jdbc:mysql://localhost:3306/myjavacode2";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String[] args) {
	
		Connection conn = null;
		Statement stmt = null;
		
		try 
		{
			// STEP 3 : Open a connection
			System.out.println("Connecting to database ...");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			Thread.sleep(2000);
			System.out.println("Data Base is Connected");
			
			Thread.sleep(2000);
			
			// STEP 4 : Execute a querry
			System.out.println("Creating table in given database ...");
			
			stmt = conn.createStatement();
			
			// STEP 4.1 : Creating the table
			
			String sql = "CREATE TABLE registration "+
			" (id INT auto_increment primary key, " +	
			" name VARCHAR(55), " +	
			" email VARCHAR(55), " +
			" address VARCHAR(55), " +
			" phone VARCHAR(55), " +
			" city VARCHAR(55), " +
			" country VARCHAR(55), " +
			" education VARCHAR(55), " +
			" photo LONGBLOB, " +
			" date DATETIME default now() )";
			
			stmt.executeUpdate(sql);
			Thread.sleep(2000);
			System.out.println("New User Table is Created database ...");
			
			stmt.close();
			conn.close();
			
			Thread.sleep(2000);
			System.out.println("Connection closed ...");
		}
		
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			try
			{
				if (stmt != null)
					stmt.close();
			}
			
			catch (SQLException se2)
			{
				
			} // nothing we can do
			
			try
			{
				if(conn != null)
					conn.close();
			}
			
			catch (SQLException se)
			{
				se.printStackTrace();
			} // end finally try
		} // end try
	}
}

		
		