import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainMenu extends JFrame
{
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel productsPanel;
    private JPanel productPanel1;
    private JButton accountButton;
    private JTabbedPane menuTabbedPane;
    private JPanel titleLabelPanel;
    private JPanel cartPanel;
    private JPanel accountPanel;
    private JLabel pNameLabel1;
    private JPanel productPanel2;
    private JPanel productPanel3;
    private JPanel productPanel4;
    private JLabel pNameLabel2;
    private JLabel prodDescLabel1;
    private JLabel prodPriceLabel1;
    private JLabel pQuantLabel1;
    private JLabel prodDescLabel2;
    private JLabel prodPriceLabel2;
    private JLabel pQuantLabel2;
    private JButton addToCart1;
    private JButton changePasswordButton;
    private JPanel updateCustomerDetailPanel;
    private JPanel changePasswordPanel;
    private JTabbedPane accountTabbedPanel;
    private JPanel updateCustomerContentPanel;
    private JTextField updateNameTextField;
    private JPanel updateNamePanel;
    private JPanel updateCustomerEmail;
    private JPanel updateAddressPanel;
    private JTextField updateEmailTextField;
    private JTextArea updateAddressTextArea;
    private JPanel updateButtonPanel;
    private JButton updateDetailsButton;
    private JPanel currentPassPanel;
    private JPanel updatePassPanel;
    private JPanel updatePassConfirmPanel;
    private JPanel updatePassBttnPanel;
    private JPasswordField updatePassConfirmField;
    private JPasswordField currentPassField;
    private JPasswordField updatePassField;
    private JLabel currentPassLabel;
    private JLabel updatePassLabel;
    private JLabel updatePassConfirmLabel;
    private JPanel confirmDeletePanel;
    private JPanel deleteCustomerPanel;
    private JPanel deleteButtonPanel;
    private JButton deleteAccountButton;
    private JPasswordField delCusField;
    private JPanel signOutPanel;
    private JButton signOutButton;
    private JPanel cartPanel1;
    private JLabel cartLabel1;
    private JLabel cartLabel2;
    private JLabel cartLabel3;
    private JLabel cartLabel4;
    private JButton makeOrderButton;
    private JLabel orderTotalLabel;
    private JLabel orderCostLabel;
    private JButton addToCart2;
    private JButton addToCart3;
    private JLabel pNameLabel3;
    private JLabel prodDescLabel3;
    private JButton addToCart4;
    private JLabel pNameLabel4;
    private JLabel prodDescLabel4;
    private JLabel prodPriceLabel3;
    private JLabel prodPriceLabel4;
    private JLabel pQuantLabel3;
    private JLabel pQuantLabel4;
    private JLabel[] cartLabelList = {cartLabel1,cartLabel2,cartLabel3,cartLabel4};
    private int cartLabelCounter = 0;
    private int stockQuantity = 0;

    MainMenu(ResultSet cSet, ResultSet pSet) throws SQLException
    {
        //Set up Java Swing components
        setTitle("Main Menu | DP Tech Store");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        setResizable(false);

        //Product Cost Price for labels
        double costPrice = 0;

        //**************
        //Product Panels
        //**************

        //Display Product Details for Product Panel 1
        //Product Name Label
        pNameLabel1.setText(pSet.getString(2));
        //Product Description Label
        prodDescLabel1.setText(pSet.getString(3));
        //Product Price Label
        costPrice = Double.parseDouble(pSet.getString(4));
        prodPriceLabel1.setText("€" + costPrice);
        //Product Quantity Label
        stockQuantity = Integer.parseInt(pSet.getString(5));
        pQuantLabel1.setText("In Stock: " + stockQuantity);

        //Disables button if stock quantity is '0'
        if(!Retrieve.verifyProductQuantity(pNameLabel1.getText()))
        {
            //Disable button
            addToCart1.setEnabled(false);
            //Update Label
            addToCart1.setText("Out of Stock");
        }//end if

        //Adds product to cart
        addToCart1.addActionListener(new ActionListener()
        {
            //Store product quantity to be displayed after item is added to cart
            int updatedQuantity = (Integer.parseInt(pQuantLabel1.getText().substring(10))) -1 ;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Disable button
                addToCart1.setEnabled(false);
                //Display option pane
                JOptionPane.showMessageDialog(mainPanel,"Due to anti-scalper policies, only one unit of each product can be sold per order.","One Unit Only",JOptionPane.WARNING_MESSAGE);

                //Update label in view cart page
                cartLabelList[cartLabelCounter].setText(pNameLabel1.getText());
                cartLabelCounter ++;

                //Get product cost
                double orderTotalCurr = Double.parseDouble(orderCostLabel.getText());
                //Add to current order total
                orderTotalCurr += Double.parseDouble(prodPriceLabel1.getText().substring(1));
                //Update Order Total
                orderCostLabel.setText(String.valueOf(orderTotalCurr));

                //Update Product Quantity
                Update.updateProductQuantity(pNameLabel1.getText());
                pQuantLabel1.setText("In Stock: " + updatedQuantity);

                //Check that product quantity is not '0'
                if(!Retrieve.verifyProductQuantity(pNameLabel1.getText()))
                {
                    //Disable button
                    addToCart1.setEnabled(false);
                    //Update Label
                    addToCart1.setText("Out of Stock");
                }//end if statement
            }//end actionPerformed method
        });//end action listener

        //Display Product Details for Product Panel 2
        pSet.next();
        //Product Name Label
        pNameLabel2.setText(pSet.getString(2));
        //Product Description Label
        prodDescLabel2.setText(pSet.getString(3));
        //Product Price Label
        costPrice = Double.parseDouble(pSet.getString(4));
        prodPriceLabel2.setText("€" + costPrice);
        //Product Quantity Label
        stockQuantity = Integer.parseInt(pSet.getString(5));
        pQuantLabel2.setText("In Stock: " + stockQuantity);

        //Disables button if stock quantity is '0'
        if(!Retrieve.verifyProductQuantity(pNameLabel2.getText()))
        {
            //Disable button
            addToCart2.setEnabled(false);
            //Update Label
            addToCart2.setText("Out of Stock");
        }//end if

        //Adds product to cart
        addToCart2.addActionListener(new ActionListener()
        {
            //Store product quantity to be displayed after item is added to cart
            int updatedQuantity = (Integer.parseInt(pQuantLabel2.getText().substring(10))) -1 ;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Disable button
                addToCart2.setEnabled(false);
                //Display option pane
                JOptionPane.showMessageDialog(mainPanel,"Due to anti-scalper policies, only one unit of each product can be sold per order.","One Unit Only",JOptionPane.WARNING_MESSAGE);

                //Update label in view cart page
                cartLabelList[cartLabelCounter].setText(pNameLabel2.getText());
                cartLabelCounter ++;

                //Get product cost
                double orderTotalCurr = Double.parseDouble(orderCostLabel.getText());
                //Add to current order total
                orderTotalCurr += Double.parseDouble(prodPriceLabel2.getText().substring(1));
                //Update Order Total
                orderCostLabel.setText(String.valueOf(orderTotalCurr));

                //Update Product Quantity
                Update.updateProductQuantity(pNameLabel2.getText());
                pQuantLabel2.setText("In Stock: " + updatedQuantity);

                //Check that product quantity is not '0'
                if(!Retrieve.verifyProductQuantity(pNameLabel2.getText()))
                {
                    //Disable button
                    addToCart2.setEnabled(false);
                    //Update Label
                    addToCart2.setText("Out of Stock");
                }//end if statement
            }//end actionPerformed method
        });//end action listener

        //Display Product Details for Product Panel 3
        pSet.next();
        //Product Name Label
        pNameLabel3.setText(pSet.getString(2));
        //Product Description Label
        prodDescLabel3.setText(pSet.getString(3));
        //Product Price Label
        costPrice = Double.parseDouble(pSet.getString(4));
        prodPriceLabel3.setText("€" + costPrice);
        //Product Quantity Label
        stockQuantity = Integer.parseInt(pSet.getString(5));
        pQuantLabel3.setText("In Stock: " + stockQuantity);

        //Disables button if stock quantity is '0'
        if(!Retrieve.verifyProductQuantity(pNameLabel3.getText()))
        {
            //Disable button
            addToCart3.setEnabled(false);
            //Update Label
            addToCart3.setText("Out of Stock");
        }//end if

        //Adds product to cart
        addToCart3.addActionListener(new ActionListener()
        {
            //Store product quantity to be displayed after item is added to cart
            int updatedQuantity = (Integer.parseInt(pQuantLabel3.getText().substring(10))) -1 ;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Disable button
                addToCart3.setEnabled(false);
                //Display option pane
                JOptionPane.showMessageDialog(mainPanel,"Due to anti-scalper policies, only one unit of each product can be sold per order.","One Unit Only",JOptionPane.WARNING_MESSAGE);

                //Update label in view cart page
                cartLabelList[cartLabelCounter].setText(pNameLabel3.getText());
                cartLabelCounter ++;

                //Get product cost
                double orderTotalCurr = Double.parseDouble(orderCostLabel.getText());
                //Add to current order total
                orderTotalCurr += Double.parseDouble(prodPriceLabel3.getText().substring(1));
                //Update Order Total
                orderCostLabel.setText(String.valueOf(orderTotalCurr));

                //Update Product Quantity
                Update.updateProductQuantity(pNameLabel3.getText());
                pQuantLabel3.setText("In Stock: " + updatedQuantity);

                //Check that product quantity is not '0'
                if(!Retrieve.verifyProductQuantity(pNameLabel3.getText()))
                {
                    //Disable button
                    addToCart3.setEnabled(false);
                    //Update Label
                    addToCart3.setText("Out of Stock");
                }//end if statement
            }//end actionPerformed method
        });//end action listener

        //Display Product Details for Product Panel 4
        pSet.next();
        //Product Name Label
        pNameLabel4.setText(pSet.getString(2));
        //Product Description Label
        prodDescLabel4.setText(pSet.getString(3));
        //Product Price Label
        costPrice = Double.parseDouble(pSet.getString(4));
        prodPriceLabel4.setText("€" + costPrice);
        //Product Quantity Label
        stockQuantity = Integer.parseInt(pSet.getString(5));
        pQuantLabel4.setText("In Stock: " + stockQuantity);

        //Disables button if stock quantity is '0'
        if(!Retrieve.verifyProductQuantity(pNameLabel4.getText()))
        {
            //Disable button
            addToCart4.setEnabled(false);
            //Update Label
            addToCart4.setText("Out of Stock");
        }//end if

        //Adds product to cart
        addToCart4.addActionListener(new ActionListener()
        {
            //Store product quantity to be displayed after item is added to cart
            int updatedQuantity = (Integer.parseInt(pQuantLabel4.getText().substring(10))) -1 ;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Update label in view cart page
                cartLabelList[cartLabelCounter].setText(pNameLabel4.getText());
                cartLabelCounter ++;

                //Disable button
                addToCart4.setEnabled(false);
                //Display option pane
                JOptionPane.showMessageDialog(mainPanel,"Due to anti-scalper policies, only one unit of each product can be sold per order.","One Unit Only",JOptionPane.WARNING_MESSAGE);

                //Get product cost
                double orderTotalCurr = Double.parseDouble(orderCostLabel.getText());
                //Add to current order total
                orderTotalCurr += Double.parseDouble(prodPriceLabel4.getText().substring(1));
                //Update Order Total
                orderCostLabel.setText(String.valueOf(orderTotalCurr));

                //Update Product Quantity
                Update.updateProductQuantity(pNameLabel4.getText());
                pQuantLabel4.setText("In Stock: " + updatedQuantity);

                //Check that product quantity is not '0'
                if(!Retrieve.verifyProductQuantity(pNameLabel4.getText()))
                {
                    //Disable button
                    addToCart4.setEnabled(false);
                    //Update Label
                    addToCart4.setText("Out of Stock");
                }//end if
            }//end action Performed method
        });//end action listener

        //**************
        //View Cart Pane
        //**************
        //Sets initial values of View Cart Labels
        orderCostLabel.setText("0.0");
        cartLabel1.setText("");
        cartLabel2.setText("");
        cartLabel3.setText("");
        cartLabel4.setText("");

        //Make Order Button
        makeOrderButton.addActionListener(new ActionListener()
        {
            //Stores customerId
            String cId = cSet.getString("customerId");
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Display confirm dialog option pane
                int orderOption = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you wish to complete your order? Or do you wish to cancel your order?","Confirm Order", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                //If statements for confirmDialog pane
                //Customer selects yes
                if(orderOption == JOptionPane.YES_OPTION)
                {
                    //Store cart product names
                    String orderProducts = cartLabel1.getText() + cartLabel2.getText() + cartLabel3.getText() + cartLabel4.getText();
                    //Create order
                    Create.createOrder(cId,orderProducts);
                    //Display confirmation message
                    JOptionPane.showMessageDialog(mainPanel,"Ordered successfully", "Order Made", JOptionPane.PLAIN_MESSAGE);
                }//end if
                //Customer cancels order
                else if(orderOption == JOptionPane.CANCEL_OPTION)
                {
                    //Display cancellation message
                    JOptionPane.showMessageDialog(mainPanel,"Order Cancelled.", "Order Cancelled", JOptionPane.PLAIN_MESSAGE);
                }//end if
                //Else error has occurred
                else
                {
                    //Display error message
                    JOptionPane.showMessageDialog(mainPanel, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                }//end else

                //Setting labels to blank again
                //Checks if label is not empty

                if(!cartLabel1.getText().isEmpty() || !cartLabel2.getText().isEmpty() || !cartLabel3.getText().isEmpty() || !cartLabel4.getText().isEmpty())
                {
                    //Re-enable add to cart buttons
                    addToCart1.setEnabled(true);
                    addToCart2.setEnabled(true);
                    addToCart3.setEnabled(true);
                    addToCart4.setEnabled(true);

                    //Reset product quantity
                    Update.resetQuantity(cartLabel1.getText());
                    Update.resetQuantity(cartLabel2.getText());
                    Update.resetQuantity(cartLabel3.getText());
                    Update.resetQuantity(cartLabel4.getText());

                    //Reset cart product label
                    cartLabel1.setText("");
                    cartLabel2.setText("");
                    cartLabel3.setText("");
                    cartLabel4.setText("");

                }//end nested if
                //Reset total order cost
                orderCostLabel.setText("0");
            }//end action Performed method
        });//end action listener

        //**************
        //Manage Details
        //**************

        //***********************
        //Update Customer Details
        //***********************
        updateEmailTextField.setText(cSet.getString(2));
        updateNameTextField.setText(cSet.getString(4));
        updateAddressTextArea.setText(cSet.getString(5));

        //Update Customer Details Action Listener
        updateDetailsButton.addActionListener(new ActionListener()
        {
            //Store customer id
            String cId = cSet.getString(1);
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Store entered details in variables
                String updateEmail = updateEmailTextField.getText();
                String updateName = updateNameTextField.getText();
                String updateAddress = updateAddressTextArea.getText();

                //If all fields are full and email has not changed
                if(Update.verifyNotNull(updateEmail,updateName,updateAddress) && Update.verifyUpdateEmail(updateEmail, cId))
                {
                    //Update record
                    Update.updateCustomerDetails(cId,updateEmail,updateName,updateAddress);
                    //Display option pane
                    JOptionPane.showMessageDialog(mainPanel,"Account details have been successfully updated.", "Account Updated", JOptionPane.PLAIN_MESSAGE);
                }//end if
                //If all fields are full and email has been changed and is unique
                else if(!Update.verifyUpdateEmail(updateEmail, cId) && Update.verifyNotNull(updateEmail,updateName,updateAddress) && Create.verifyEmail(updateEmail))
                {
                    Update.updateCustomerDetails(cId,updateEmail,updateName,updateAddress);
                    JOptionPane.showMessageDialog(mainPanel,"Account details have been successfully updated.", "Account Updated", JOptionPane.PLAIN_MESSAGE);
                }//end else if
                //New email is not unique
                else if(!Update.verifyUpdateEmail(updateEmail, cId) && !Create.verifyEmail(updateEmail))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Account with this email already exists!", "Email Error", JOptionPane.WARNING_MESSAGE);
                }//end else if
                //Fields are left blank
                else if(!Update.verifyNotNull(updateEmail,updateName,updateAddress))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Fields cannot be left blank!", "Blank Fields", JOptionPane.WARNING_MESSAGE);
                }//end if else
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                }//end else
            }//end action Performed
        });//end action listener

        //***************
        //Update Password
        //***************

        //Update Customer Password Action Listener
        changePasswordButton.addActionListener(new ActionListener()
        {
            //Store customer email
            String cEmail = cSet.getString("customerEmail");
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Store entered values
                String currentPass = String.valueOf(currentPassField.getPassword());
                String updatePass = String.valueOf(updatePassField.getPassword());
                String updateConPass = String.valueOf(updatePassConfirmField.getPassword());

                //Checks that new passwords match and are not empty, and that current password is valid
                if(updatePass.equals(updateConPass) && Retrieve.logIn(cEmail, currentPass) && Update.verifyNotNull(updatePass,updateConPass))
                {
                    //Update password
                    Update.updatePassword(cEmail,updateConPass);
                    JOptionPane.showMessageDialog(mainPanel,"Password has been successfully updated.", "Account Updated", JOptionPane.PLAIN_MESSAGE);
                }//end if
                //Passwords don't match
                else if(!updatePass.equals(updateConPass))
                {
                    JOptionPane.showMessageDialog(mainPanel, "New passwords must match!", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
                }//end else if
                //Current password is invalid
                else if(!Retrieve.logIn(cEmail,currentPass))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid log in details", "Incorrect Login ", JOptionPane.WARNING_MESSAGE);
                }//end else if
                //New password fields are empty
                else if(!Update.verifyNotNull(updatePass,updateConPass))
                {
                    JOptionPane.showMessageDialog(mainPanel, "New passwords fields cannot be left empty", "Empty Fields", JOptionPane.WARNING_MESSAGE);
                }//end else if
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                }//end else
            }//end action performed method
        });//end action listener

        //Delete Customer action listener
        deleteAccountButton.addActionListener(new ActionListener()
        {
            //Store customer email
            String cEmail = cSet.getString("customerEmail");
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Store customer password entered
                String delPass = String.valueOf(delCusField.getPassword());

                //Password validates
                if(Retrieve.logIn(cEmail,delPass))
                {
                    //Prompt user to confirm delete
                    int delOption = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you wish to delete your account? This cannot be undone.","Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    //User confirms deletion
                    if(delOption == JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(mainPanel,"Account has been successfully deleted. Thank you and good bye.", "Account Deleted", JOptionPane.PLAIN_MESSAGE);
                        //Delete customer record
                        Delete.deleteCustomer(cEmail);
                        dispose();
                        //Start new window
                        new LogInScreen();
                    }//end if
                    //User cancels deletion
                    else if(delOption == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(mainPanel,"You have cancelled the deletion of your account.", "Account Not Deleted", JOptionPane.PLAIN_MESSAGE);
                    }//end else if
                }//end if
                //Password not validated
                else if(!Retrieve.logIn(cEmail,delPass))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid log in details", "Incorrect Login ", JOptionPane.WARNING_MESSAGE);
                }//end else if
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                }//end else
            }//end action performed method
        });//end action listener

        //Sign Out action listener
        signOutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Prompt user to confirm signing out
                int signOutOption = JOptionPane.showConfirmDialog(mainPanel,"Are you sure you wish to sign out of your account?","Sign Out", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                //User confirms to signing out
                if(signOutOption == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(mainPanel,"You have successfully signed out. Thank you and good bye.", "Signed Out", JOptionPane.PLAIN_MESSAGE);
                    //Exit program
                    dispose();
                    //Display log in screen
                    new LogInScreen();
                }//end if
                //User cancels signing out
                else if(signOutOption == JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(mainPanel,"You have signing out of your account.", "Not Signed Out", JOptionPane.PLAIN_MESSAGE);
                }//end else if
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Error", "Error", JOptionPane.WARNING_MESSAGE);
                }//end else
            }//end actionPerfomred method
        });//end action listener

    }//end MainMenu
}//end class
