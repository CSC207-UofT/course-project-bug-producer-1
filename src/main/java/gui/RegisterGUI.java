package gui;

import user.UserController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This is a JFrame class is the Register class for GUI which handles
 * all the account register process
 * @author Walter
 */
public class RegisterGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel userLabel = new JLabel("Username: ");
    private final JTextField usernameField = new JTextField();
    private final JLabel pwdLabel = new JLabel("Password: ");
    private final JPasswordField passwordField = new JPasswordField();
    private final JLabel emailLabel = new JLabel("Email: ");
    private final JTextField emailField = new JTextField();
    private final JButton regButton = new JButton("Register");
    private final JButton clearButton = new JButton("Clear");
    private final JTextField code = new JTextField();
    private final JLabel codeLabel = new JLabel("Secret code: ");

    /**
     * Class constructor
     * Creates a new Register window inside the main program GUI window.
     * This method does not have any return type.
     */
    public RegisterGUI(){
        setTitle("User Register");
        setBounds(600, 300, 400, 300);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
        setVisible(true);
    }


    /**
     * Initialize the program window
     * This method does not have any return type.
     *
     */
    private void init(){
        // FieldPanel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        userLabel.setBounds(50, 20, 80, 20);
        pwdLabel.setBounds(50, 60, 80, 20);
        emailLabel.setBounds(50, 100, 80, 20);
        codeLabel.setBounds(50, 140, 80, 20);
        usernameField.setBounds(130, 20, 160, 20);
        passwordField.setBounds(130, 60, 160, 20);
        emailField.setBounds(130, 100, 160, 20);
        code.setBounds(130, 140, 160, 20);
        fieldPanel.add(userLabel);
        fieldPanel.add(pwdLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordField);
        fieldPanel.add(emailField);
        fieldPanel.add(emailLabel);
        fieldPanel.add(code);
        fieldPanel.add(codeLabel);
        container.add(fieldPanel, "Center");

        // ButtonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(regButton);
        buttonPanel.add(clearButton);
        container.add(buttonPanel, "South");
        listener();
    }


    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */
    private void listener(){
        regButton.addActionListener(
                e -> {
                    boolean flag = false;
                    String user = usernameField.getText();
                    String pass = String.valueOf(passwordField.getPassword());
                    String secret_code = code.getText();
                    String email = emailField.getText();
                    if (null == user
                            || user.trim().length() == 0
                            || pass.trim().length() == 0){
                        JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
                    }else if(null == email
                            || email.trim().length() <= 5
                            || !email.contains("@")
                            || !email.contains(".")){
                        JOptionPane.showMessageDialog(null, "You must enter a valid Email address!");
                    }else{
                        try {
                            flag = UserController.register(user, secret_code, pass, email);
                        } catch (IOException ex) {
                            System.out.print("Error Detected, Please contact Author.");
                        }
                        if (flag){
                            JOptionPane.showMessageDialog(null, "Registration successful");
                            dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Registration failed!");
                        }
                    }





                }
        );

        clearButton.addActionListener(
                e -> {
                    usernameField.setText("");
                    passwordField.setText("");
                    emailField.setText("");
                    code.setText("");
                }
        );
    }
}



