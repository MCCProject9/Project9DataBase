//	CreateCollegeDB.java by Kyle Wolff and Brandon VanderMey on 4/30/2015

import java.sql.*;

public class CreateCollegeDB
{
	public static void main(String[] args)
	{
		final String DB_URL = "jdbc:derby:CollegeDB;create=true";
		
		try
		{
			Connection connection = DriverManager.getConnection(DB_URL);
			
			dropTables(connection);
			
			buildStudentsTable(connection);
		}
		
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	public static void dropTables(Connection connection)
	{
		System.out.println("Checking for existing tables.");
		
		try
		{
			Statement statement = connection.createStatement();
			
			try
			{
				statement.execute("DROP TABLE Students");
				System.out.println("Students table dropped.");
			}
			
			catch (SQLException ex)
			{
				
			}
		}
		
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void buildStudentsTable(Connection connection)
	{
		System.out.println("Creating Students table");
		
		try
		{
			Statement statement = connection.createStatement();
			
			//	Create the table.
			statement.execute("CREATE TABLE Students (" +
					"StudentNumber CHAR(7) NOT NULL PRIMARY KEY, " +
					"FirstName CHAR(15), " +
					"LastName CHAR(25), " +
					"MajorCode CHAR(3)" +
					")");
			
			//	Insert row #1
			statement.execute("INSERT INTO Students VALUES ('0123456', 'Brandon', 'VanderMey', '88A')");
			
			//	Insert row #2
			statement.execute("INSERT INTO Students VALUES ('5167856', 'Kyle', 'Wolff', '88B')");
			
			//	Insert row #3
			statement.execute("INSERT INTO Students VALUES ('4830478', 'Lance', 'May', 'AA9')");
			
			//	Insert row #4
			statement.execute("INSERT INTO Students VALUES ('5498887', 'Geri', 'Berry', '990')");
			
			//	Insert row #5
			statement.execute("INSERT INTO Students VALUES ('0999083', 'Hunter', 'Crothers', '9EE')");
			
		}
		
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}
