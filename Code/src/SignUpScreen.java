import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class SignUpScreen extends JFrame
{
    private JPanel mainPanel;
    private JTextField emailTextField;
    private JTextField passwordConfrimTextField;
    private JPanel emailPanel;
    private JPanel passwordPanel;
    private JPanel passwordConfirmPanel;
    private JPanel namePanel;
    private JTextField nameTextField;
    private JPanel buttonPanel;
    private JButton confirmButton;
    private JLabel emailLabel;
    private JLabel password;
    private JLabel passwordConfirmLabel;
    private JLabel nameLabel;
    private JPanel messagePanel;
    private JLabel accountDetailsLabel;
    private JPasswordField passwordConfirmField;
    private JPasswordField passwordField;

    public SignUpScreen()
    {
        //Set up screen
        setTitle("Create Account");
        setSize(450,360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        //Confirm button action listener
        confirmButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Checks that email is unique, password fields match
                if(Create.verifyEmail(emailTextField.getText()) && String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordConfirmField.getPassword() )  ))
                {
                    //Create customer record
                    Create.createCustomer(emailTextField.getText(), String.valueOf(passwordConfirmField.getPassword()), nameTextField.getText());
                    JOptionPane.showMessageDialog(mainPanel, "Welcome " + nameTextField.getText() + ". You have successfully created an account!", "Account Created", JOptionPane.PLAIN_MESSAGE);
                    //Close window and go to log in screen
                    dispose();
                    LogInScreen login = new LogInScreen();
                }//end if
                //Email is not unique
                else if(!Create.verifyEmail(emailTextField.getText()))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Account with this email already exists!", "Email Error", JOptionPane.WARNING_MESSAGE);
                }//end else if
                //Passwords do not match
                else if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordConfirmField.getPassword())))
                {
                    JOptionPane.showMessageDialog(mainPanel, "Passwords must match!", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
                }//end else if
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Error!", "Error", JOptionPane.WARNING_MESSAGE);
                }//else
            }//end actionPerformed method
        });//end action listener
    }//end sign up screen
}//end class
