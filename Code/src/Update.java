/*
    Author:     Denis Perepelyuk
    Student ID: C00259076
    Purpose:    Contains all update methods
*/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update 
{
    /**
     * Updates Customer details in record
     *
     * <p>
     *      Used to update customer record in table based off of customer Id to query the table for the correct record,
     *      customer email, name and address to be updated in the record
     * </p>
     * @param cId Represents customer id to be used to query the table
     * @param cEmail Represents customer email to be used to update the current email in the record
     * @param cName Represents customer name to be used to update the current name in the record
     * @param cAddress Represents customer address to be used to update the current address in the record
     */
    //Update Customer Details
    public static void updateCustomerDetails(String cId, String cEmail, String cName, String cAddress)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "UPDATE customers SET customerEmail='"+cEmail+"', customerAddress='"+cAddress+"', customerName='"+cName+"' WHERE customerID = '"+cId+"'";
            //Execute query
            pstat.executeUpdate(sql);
            System.out.println("Account details for " + cName + " has been successfully updated.");
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in updating customer details");
            e.printStackTrace();
        }//end catch
    }//end updateCustomer method

    /**
     * Verifies that email has not been changed when updating the customer email in a record
     * @param cEmail  String representing email to be checked if it has been changed or not
     * @param cId   String representing customer id used to query database to find customer record table
     * @return {@link Boolean} if email has been not been changed
     */
    //Verify email has not been changed when updated
    public static boolean verifyUpdateEmail(String cEmail, String cId)
    {
        boolean result = false;
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "SELECT customerEmail FROM customers WHERE customerId = '"+cId+"' ";
            //Store result
            ResultSet resultSet = pstat.executeQuery(sql);

            //Initialize string to be compared
            String compareEmail = "";

            //Storing result into string
            if(resultSet.next())
            {
                 compareEmail = resultSet.getString("customerEmail");
            }
            //Compare if strings are the same
            if(compareEmail.equals(cEmail))
            {
                result = true;
            }
            return result;
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in change in email");
            e.printStackTrace();
            return false;
        }//end catch
    }//end verifyEmail method

    /**
     * Updates password of customer
     *
     * <p>
     *     Updates password of customer record in table based on customer email used to query table to find record to
     *     be updated and new password entered by user to be updated
     * </p>
     * @param cEmail String representing email used to query table
     * @param cPassword String representing new password for customer record
     */
    public static void updatePassword(String cEmail, String cPassword)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "UPDATE customers SET customerPassword='"+cPassword+"' WHERE customerEmail = '"+cEmail+"'";
            //Execute query
            pstat.executeUpdate(sql);
            System.out.println("Password has been successfully updated.");
        }

        catch(SQLException e)
        {
            System.out.println("Error in updating customer.");
            e.printStackTrace();
        }
    }//end updatePassword method

    /**
     * Verifies that fields in GUI form are not empty
     *
     * <p>
     *     Checks if fields in GUI form are not empty based on three values from fields in GUI form
     * </p>
     * @param field1 String representing value stored in text field in GUI form
     * @param field2 String representing value stored in text field in GUI form
     * @param field3 String representing value stored in text field in GUI form
     * @return {@link Boolean} returns true if fields are not empty
     */
    //Verify that fields are not empty
    public static boolean verifyNotNull(String field1, String field2, String field3)
    {
        return !field1.isEmpty() && !field2.isEmpty() && !field3.isEmpty();
    }//end verifyNotNull

    /**
     * Verifies that fields in GUI form are not empty (Overloaded Method)
     * <p>
     *     Checks if fields in GUI form are not empty based on three values from fields in GUI form
     * </p>
     * @param field1 String representing value stored in text field in GUI form
     * @param field2 String representing value stored in text field in GUI form
     * @return {@link Boolean} returns true if fields are not empty
     */

    //Verify that fields are not empty
    public static boolean verifyNotNull(String field1, String field2)
    {
        return !field1.isEmpty() && !field2.isEmpty();
    }//verifyNotNull

    //***************
    //Product Methods
    //***************

    /**
     * Updates product quantity by decrementing by '1'
     * <p>
     *     Decrements product quantity when product is added to cart by customer based on product name which is
     *     used to query table to find product record
     * </p>
     * @param pName String representing product name to query table
     */
    //Update Product Quantity
    public static void updateProductQuantity(String pName)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "UPDATE products SET productQuantity =  productQuantity - 1 WHERE  productName = '"+pName+"' ";
            //Execute update
            pstat.executeUpdate(sql);
            System.out.println("Quantity for " + pName + " has been successfully decremented");
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in decrementing quantity");
            e.printStackTrace();
        }//end catch
    }//end updateProductQuantity

    /**
     * Resets quantity of product
     * <p>
     *     Resets quantity of product by incrementing by '1' when order has been cancelled based on product
     *     name which is used to query the table to find the product record
     * </p>
     * @param pName String representing product name to query table
     */
    //Reset product quantity
    public static void resetQuantity(String pName)
    {
        try
        {
            //Connect to DB
            Statement pstat = DBConnect.getConnection().createStatement();
            //SQL Query
            String sql = "UPDATE products SET productQuantity =  productQuantity + 1 WHERE  productName = '"+pName+"' ";
            //Execute query
            pstat.executeUpdate(sql);
            System.out.println("Quantity for " + pName + " has been successfully incremented");
        }//end try
        catch(SQLException e)
        {
            System.out.println("Error in incrementing quantity");
            e.printStackTrace();
        }//end catch
    }//end resetQuantity
}//end Update class

    

