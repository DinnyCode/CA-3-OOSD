/*
    Author:     Denis Perepelyuk
    Student ID: C00259076
    Purpose:    Contains all create methods 
*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create
{
    /**
     * Creates customer and inserts record into database
     *
     * <p>
     *     Used to create customer record into database based on a customer email, customer password and customer name.
     *     Email is to be verified to be unique in implementation.
     * </p>
     * @param cEmail    A String representing the customer email which will be used as the username when logging in.
     * @param cPassword A String represented as the password of the customer used when logging in and confirming actions
     * @param cName A string representing the name of the customer.
     */
    //Create customer record
    public static void createCustomer(String cEmail, String cPassword, String cName)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "INSERT INTO customers (customerEmail, customerPassword, customerName) VALUES ('"+cEmail+"', '"+cPassword+"','"+cName+"')";
            //Execute query
            pstat.executeUpdate(sql);
            System.out.println("Account for " + cName + " has been successfully created");
        }//end try

        catch(SQLException e)
        {
            System.out.println("Error in creating customer");
            e.printStackTrace();
        }//end catch
    }//end createCustomer method

    /**
     * Verifies that customer email is unique and no other account in the database exists with the same email
     * @param cEmail String representing email that will be compared with all other emails stored in the database
     * @return boolean result depending on whether the email is unique or not
     */
    //Verify email is unique
    public static boolean verifyEmail(String cEmail)
    {
        boolean result = false;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT customerEmail FROM customers WHERE customerEmail = '"+cEmail+"' ";
            //Store result
            ResultSet resultSet = pstat.executeQuery(sql);

            //Check that result is empty
            if(!resultSet.next())
            {
                result = true;
            }//end if
            return result;
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error verifying for unique email");
            e.printStackTrace();
            return false;
        }//end catch
    }//end verifyEmail method

    /**
     * Creates order record and inserts record into database
     * <p>
     *     Used to create order record in database based on customer id of customer making the order and list of products
     *     being ordered.
     * </p>
     * @param cId A string representing the customer id that is making the order
     * @param pIds  A string representing the list of products being ordered
     */
    //Create Order Record
    public static void createOrder(String cId, String pIds)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL QUERY
            String sql = "INSERT INTO orders (orderProducts, customerId, orderStatus) VALUES ('"+pIds+"','"+cId+"','pending')";
            //Execute query
            pstat.executeUpdate(sql);
            System.out.println("Order has been successfully created.");
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error creating order record");
            e.printStackTrace();
        }//end catch
    }//end create order method

}//end Create class
