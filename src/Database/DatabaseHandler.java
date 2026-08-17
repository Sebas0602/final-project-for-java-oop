package Database;

public abstract class DatabaseHandler 
{
    public static String DB_FILE = "database.db";

    public abstract void updateDatabase(String query);
    public abstract void readDatabase(String query);

    public static void printMenuHeader() 
    {
        System.out.println("==========================================");
        System.out.println("     Student Profile Database System      ");
        System.out.println("==========================================");
    }
}