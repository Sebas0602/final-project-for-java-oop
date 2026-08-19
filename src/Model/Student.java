package Model;

public class Student 
{
    private int id;
    private String name;
    private String major;
    private double gpa;
    private String classification;

    // Create private attributes 

    public Student(int id, String name, String major, double gpa, String classification) 
    {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.classification = classification;
    }
    //Constructor for creating a student 

    // Getters
    public int getId()
    { 
        return id; 
    }
    public String getName() 
    {
        return name; 
    }
    public String getMajor()
    { 
        return major;
    }
    public double getGpa()
    { 
        return gpa; 
    }
    public String getClassification()
    { 
        return classification; 
    }

    // Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setMajor(String major) 
    { 
        this.major = major; 
    }
    public void setGpa(double gpa) 
    { 
        this.gpa = gpa; 
    }
    public void setClassification(String classification) 
    { 
        this.classification = classification; 
    }

    // Format the input into a simple row
    @Override
    public String toString() 
    {
        return "ID: " + id + " |" + " Name: "  + name + " |" + " Major: " + major + " |" + " GPA: " + gpa + " |" + " Class: " + classification + " |";
    }
}