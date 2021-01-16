package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
    public static void initConnection(String dbURL, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred While Connecting to DB, See Details: " + e);;
        }
    }

    public static void closeConnection()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred While Closing DB, See Details: " + e);;
        }
    }
}
