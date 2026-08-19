package Controller;

import Database.*;
import Model.*;
import java.util.Scanner;

public class MenuController 
{
    private Scanner scanner;
    private Database db;

    public MenuController() 
    {
        this.db = new Database();
        // Initialize the database table if it does not already exist
        db.updateDatabase("CREATE TABLE IF NOT EXISTS Students (id INTEGER PRIMARY KEY, name VARCHAR(50), major VARCHAR(50), gpa REAL, classification VARCHAR(20))");
        this.scanner = new Scanner(System.in);
    }

    
    public void start() 
    {
        DatabaseHandler.printMenuHeader(); // Uses the static method from the abstract class
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

            if (choice.equals("1"))
            {
                handleStudentInsertion();   
            }

            else if(choice.equals("2"))
            {
                // Read all records from the table
                db.readDatabase("SELECT * FROM Students");
            }
            else if(choice.equals("3"))
            {
                handleStudentUpdate();
            }

            else if(choice.equals("4"))
            {
                handleStudentDeletion();
            }

            else if(choice.equals("5"))
            {
                running = false;
                System.out.println("Exiting program. Goodbye!");
            }

            else
            {
                System.out.println("Invalid choice. Try again.");
            }

            
        }
    }

    private void handleStudentInsertion()
    {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

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

    }

    private void handleStudentUpdate()
    {
        System.out.print("Enter Student ID to update: ");
        int updateId = Integer.parseInt(scanner.nextLine());
                    
        System.out.print("Enter New Major: ");
        String newMajor = scanner.nextLine();
                    
        System.out.print("Enter New GPA: ");
        double newGpa = Double.parseDouble(scanner.nextLine());

        db.updateStudent(updateId, newMajor, newGpa);
    }

    private void handleStudentDeletion()
    {
        System.out.print("Enter Student ID to delete: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
                    
        db.deleteStudent(deleteId);
    }


}