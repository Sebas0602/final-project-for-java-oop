package Controller;

import Database.Database;
import Database.DatabaseHandler;
import Model.Student;
import java.util.Scanner;

public class MenuController 
{
    
    private Database db;

    public MenuController() 
    {
        this.db = new Database();
        // Initialize the database table if it does not already exist
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Students (id VARCHAR(20) PRIMARY KEY, name VARCHAR(50), major VARCHAR(50), gpa REAL, classification VARCHAR(20))");
    }

    public void start() 
    {
        DatabaseHandler.printMenuHeader(); // Uses the static method from the abstract class
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) 
        {
            System.out.println("\nSelect an option:");
            System.out.println("1. Insert Student Record");
            System.out.println("2. Read All Student Records");
            System.out.println("3. Update Student Record");
            System.out.println("4. Delete Student Record");
            System.out.println("5. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) 
            {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    
                    System.out.print("Enter GPA: ");
                    double gpa = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Enter Classification: ");
                    String classification = scanner.nextLine();

                    // Instantiate the Student Object
                    Student newStudent = new Student(id, name, major, gpa, classification);
                    db.addStudent(newStudent);
                    break;

                case "2":
                    // Read all records from the table
                    db.readDatabase("SELECT * FROM Students");
                    break;

                case "3":
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();
                    
                    System.out.print("Enter New Major: ");
                    String newMajor = scanner.nextLine();
                    
                    System.out.print("Enter New GPA: ");
                    double newGpa = Double.parseDouble(scanner.nextLine());

                    db.updateStudent(updateId, newMajor, newGpa);
                    break;

                case "4":
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    
                    db.deleteStudent(deleteId);
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        
        scanner.close();
    }
}