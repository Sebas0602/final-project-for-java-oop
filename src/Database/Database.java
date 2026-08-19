package Database;

import Model.*;
import java.sql.*;

public class Database extends DatabaseHandler
{
    private Connection connect = null; 
	private Statement statement = null; 


    private void connectDatabase() 
	{
		try
		{
			String url = "jdbc:sqlite:database.db";
			this.connect = DriverManager.getConnection(url); 
			this.statement = connect.createStatement();
		}
		catch(SQLException e)
		{
			System.err.println("Unable to connect to database"); 
			System.err.println(e.toString()); 

		}
	}
	@Override
    public void updateDatabase(String query) {
        if (this.connect == null) {
            connectDatabase(); 
        }
        try {
            this.statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Failed to run query.");
            System.err.println(e.toString());
        }
    }

    @Override
    public void readDatabase(String query) 
	{
        if (this.connect == null) 
		{
            connectDatabase();
        }
        try 
		{
            ResultSet rs = this.statement.executeQuery(query);
            System.out.println("\n--- Database Records ---");
            
            boolean hasRecords = false;
            while (rs.next()) 
			{
                hasRecords = true;
                // Extract data from the database
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String major = rs.getString("major");
                double gpa = rs.getDouble("gpa");
                String classification = rs.getString("classification");

                // Instantiate the Student object 
                Student s = new Student(id, name, major, gpa, classification);
                System.out.println(s.toString());
            }
            
            if (!hasRecords) 
			{
            	System.out.println("No records found in database.");
            }
            
        } 
		
		catch (SQLException e) 
		{
            System.err.println("Failed to read from database.");
            System.err.println(e.toString());
        }
    }


    public void addStudent(Student student) 
	{
        String query = String.format("INSERT INTO Students (id, name, major, gpa, classification) VALUES (%d, '%s', '%s', %f, '%s')",
        student.getId(), student.getName(), student.getMajor(), student.getGpa(), student.getClassification());
        updateDatabase(query);
        System.out.println("Student added successfully.");
    }

    public void updateStudent(int id, String newMajor, double newGpa) 
	{
        String query = String.format("UPDATE Students SET major = '%s', gpa = %f WHERE id = %d", newMajor, newGpa, id);
        updateDatabase(query);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) 
	{
        String query = ("DELETE FROM Students WHERE id = " + id);
        updateDatabase(query);
        System.out.println();
        System.out.println("Student deleted successfully.");
    }
}
