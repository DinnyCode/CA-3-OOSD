import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LogInScreen extends JFrame
{
    private JPanel mainPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton logInButton;
    private JButton signUpButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LogInScreen()
    {
        //Set up form
        setTitle("Welcome Screen");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        //add action listener to log in
        logInButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Checks that log in details are valid
                if(Retrieve.logIn(usernameTextField.getText(),String.valueOf(passwordTextField.getPassword())))
                {
                    //Dispose screen
                    dispose();
                    try
                    {
                        //Create Main Menu Frame
                        new MainMenu(Retrieve.passCustomerDetails(usernameTextField.getText()) , Retrieve.passProducts()) ;
                    }//end try
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }//end catch
                }//end if
                else
                {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid log in details", "Incorrect Login ", JOptionPane.WARNING_MESSAGE);
                }//end else
            }//end actionPerformed method
        });//end action listener

        //Add sign up listener
        signUpButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Create sign up screen
                dispose();
                SignUpScreen signUp = new SignUpScreen();
            }//end actionPerformed method
        });//end  Action Listener
    }//end sign in screen
}//end class
