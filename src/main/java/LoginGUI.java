package main.java;

import javax.swing.*;
import java.awt.*;


public class LoginGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel userLabel = new JLabel("Username: ");
    private final JTextField usernameField = new JTextField();
    private final JLabel pwdLabel = new JLabel("Password: ");
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Login");
    private final JButton clearButton = new JButton("Clear");
    private static String username = "";

    /**
     * Class constructor
     * Creates a new Login GUI window.
     * This method does not have any return type.
     */
    public LoginGUI(){
        setTitle("Bug-Producer Login Window");
        setBounds(600, 200, 400, 200);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    /**
     * Returns the username of the user who is currently using this software.
     * @return the username of the User
     */
    public static String getUsername(){
        return username;
    }

    /**
     * Initialize the program
     * This method does not have any return type.
     *
     */
    private void init(){
        // FieldPanel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        userLabel.setBounds(50, 20, 80, 20);
        pwdLabel.setBounds(50, 60, 80, 20);
        usernameField.setBounds(130, 20, 160, 20);
        passwordField.setBounds(130, 60, 160, 20);
        fieldPanel.add(userLabel);
        fieldPanel.add(pwdLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordField);
        container.add(fieldPanel, "Center");

        // ButtonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
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
        loginButton.addActionListener(
                e -> {
                    username = usernameField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    if (null == username
                            || username.trim().length() == 0
                            || password.trim().length() == 0){
                        JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
                    }

                    else if ("root".equals(username) && "admin".equals(password)){
                        JOptionPane.showMessageDialog(null, "Login Success!");
                        new MainGUI();
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Credentials!");
                    }
                }
        );

        clearButton.addActionListener(
                e -> {
                    usernameField.setText("");
                    passwordField.setText("");
                }
        );
    }
}
