/*
    Author:     Denis Perepelyuk
    Student ID: C00259076
    Purpose:    Contains all delete methods
*/
import java.sql.SQLException;
import java.sql.Statement;

public class Delete 
{
    /**
     * Deletes customer from table
     * <p>
     *     Used to delete a customer from a table based on the email which is unique and will only exist one
     *     record in the table with this email.
     * </p>
     * @param cEmail Represents email to be checked for in the database
     */
    //Delete Customer record
    public static void deleteCustomer(String cEmail)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "DELETE FROM customers WHERE customerEmail = '"+cEmail+"' ";
            //Execute Query
            pstat.execute(sql);
            System.out.println("Customer account: " + cEmail + " has been deleted");
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in deleting customer");
            e.printStackTrace();
        }//end catch
    }//end deleteCustomer method
}//end Delete class
