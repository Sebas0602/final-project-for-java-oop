package Model;

public class Student 
{
    private String id;
    private String name;
    private String major;
    private double gpa;
    private String classification;

    public Student(String id, String name, String major, double gpa, String classification) 
    {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.classification = classification;
    }

    // Getters
    public String getId()
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

    @Override
    public String toString() 
    {
        return String.format("ID: %-10s | Name: %-18s | Major: %-12s | GPA: %-4.2f | Class: %s", id, name, major, gpa, classification);
    }
}