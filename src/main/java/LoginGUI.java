package main.java;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JFrame {
    private Container container = getContentPane();
    private static JLabel userLabel = new JLabel("Username: ");
    private static JTextField usernameField = new JTextField();
    private static JLabel pwdLabel = new JLabel("Password: ");
    private static JPasswordField passwordField = new JPasswordField();
    private static JButton loginButton = new JButton("Login");
    private static JButton clearButton = new JButton("Clear");
    private static String username = "";

    public LoginGUI(){
        setTitle("Bug-Producer Login Window");
        setBounds(600, 200, 400, 200);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    public static String getUsername(){
        return username;
    }

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
                        MainGUI gui = new MainGUI();
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
