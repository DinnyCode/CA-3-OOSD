/*
    Author:     Denis Perepelyuk
    Student ID: C00259076
    Purpose:    Connects Java project to database
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect
{
    //Database variables
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/oosd-project";

    /**
     * Connects the Java program to the database
     * <p>
     *     Connects to a database based on the username, password and url of the database
     * </p>
     * @return A {@link Connection} which is used to connect the Java project to the database
     */
    //Connect to Database
    public static Connection getConnection()
    {
        //Set connection to null
        Connection con = null;
        try
        {
            //Connect to DB
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }//end try
        catch (SQLException e)
        {
            System.out.println("Error connecting to Database");
            e.printStackTrace();
        }//end catch
        return con;
    }//end getConnection method
}//end DBConnect class
