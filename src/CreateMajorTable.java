//	CreateMajorTable.java by Kyle Wolff and Brandon VanderMey on 4/30/2015

import java.sql.*;

public class CreateMajorTable
{
	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:CollegeDB";
		
		try
		{
			Connection connection = DriverManager.getConnection(DB_URL);
			
			Statement statement = connection.createStatement();
			
			try
			{
				statement.execute("DROP TABLE Majors");
				System.out.println("Majors table dropped.");
			}
			
			catch (Exception ex) {}
			
			try
			{
				statement.execute("CREATE TABLE Majors (MajorCode CHAR(3) PRIMARY KEY, Description CHAR(50))");
				
			}
			
			catch (Exception ex)
			{
				System.out.println("Error: " + ex.getMessage());
			}
		}
		
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
