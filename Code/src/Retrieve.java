import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Retrieve 
{
    //*************************
    //Retrieve Customer Methods
    //*************************

    /**
     * Verifies log in credentials of customer
     *
     * <p>
     *      Used to verify login credentials of customer based on email and password entered by the customer
     * </p>
     * @param cEmail  String representing email entered by customer
     * @param cPassword  String representing password entered by customer
     * @return {@link Boolean} depending on whether the login credentials were valid
     */
    //Validates user log in
    public static boolean logIn(String cEmail, String cPassword)
    {
        boolean result = false;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT customerEmail, customerPassword FROM customers WHERE customerEmail = '"+cEmail+"' AND customerPassword = '"+cPassword+"' ";
            //Store result in ResultSet
            ResultSet resultSet = pstat.executeQuery(sql);

            //Return true
            if(resultSet.next())
            {
                result = true;
            }
            return result;
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in validating log in details");
            e.printStackTrace();
            return false;
        }//end catch
    }//end method

    /**
     * Returns ResultSet of customer details
     * <p>
     *     Used to retrieve all details of customer based on customer email as email's are unique in the database and
     *     no two records can have the same email
     * </p>
     * @param cEmail String representing email to be checked for with records in the table
     * @return {@link ResultSet} containing all details of record returned from query
     */
    //Returns customer details
    public static ResultSet passCustomerDetails(String cEmail)
    {
        ResultSet resultSet = null;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT * FROM customers WHERE customerEmail = '"+cEmail+"' ";
            //Store result in result set
            resultSet = pstat.executeQuery(sql);

            //Return result set containing customer details
            if(resultSet.next())
            {
                return resultSet;
            }
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in returning user details");
            e.printStackTrace();
        }//end catch
        return resultSet;
    }//end method

    //*****************************
    //Retrieval of Products Methods
    //*****************************

    /**
     * Verifies that product quantity is not at '0'
     * <p>
     *     Checks that product record returned from query does not contain the value '0' in the
     *     quantity column and returns output based on whether or not it does.
     * </p>
     * @param pName String representing product name which is used to query database for matching record
     * @return {@link Boolean} result based on if the quantity is at '0' or not
     */
    //Verify product quantity
    public static boolean verifyProductQuantity(String pName)
    {
        boolean result = false;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT productQuantity FROM products WHERE productName = '"+pName+"' ";
            //Store result in ResultSet
            ResultSet resultSet = pstat.executeQuery(sql);

            //Return true if result set is not empty
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                {
                    result = true;
                }//end nested if
            }//end if
            return result;
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in verifying product quantity");
            e.printStackTrace();
            return false;
        }//end catch
    }//end method

    /**
     * Returns ResultSet of product details for all product records in the table
     * <p>
     *     Used to retrieve all details of all product records in the products table
     * </p>
     * @return {@link ResultSet} of containing all records in the products table
     */
    //Return all product records
    public static ResultSet passProducts()
    {
        ResultSet resultSet = null;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT * FROM products";
            //Stores query result
            resultSet = pstat.executeQuery(sql);

            //Return result of all products
            if(resultSet.next())
            {
                return resultSet;
            }
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in passing products.");
            e.printStackTrace();
        }//end catch
        return resultSet;
    }//end method

}//end Retrieve Class
