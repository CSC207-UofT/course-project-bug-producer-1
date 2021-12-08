package gui;

import user.UserController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



/**
 * This class is the login class for GUI which handles
 * the login and registration process. (only GUI)
 * @author Yuehao Huang
 */

public class LoginGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel userLabel = new JLabel("Username: ");
    private final JTextField usernameField = new JTextField();
    private final JLabel pwdLabel = new JLabel("Password: ");
    private final JPasswordField passwordField = new JPasswordField();
    private final JLabel codeLabel = new JLabel("Secret Code: ");
    private final JPasswordField codeField = new JPasswordField();
    private final JButton loginButton = new JButton("Login");
    private final JButton clearButton = new JButton("Clear");
    private static String user;
    private final JButton regButton = new JButton("Register");
    private final JPanel bkgPanel = new JPanel();

    /**
     * Class constructor
     * Creates a new Login GUI window.
     * This method does not have any return type.
     */
    public LoginGUI(){
        setIconImage(Constant.getImage("icon.png"));
        setTitle("Bug-Producer Login Window");
        setBounds(600, 200, 600, 300);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);
        user = "";
    }

    /**
     * Returns the username of the user who is currently using this software.
     * @return the username of the User
     */


    /**
     * Initialize the program
     * This method does not have any return type.
     *
     */
    private void init(){
        // FieldPanel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        userLabel.setBounds(180, 20, 80, 20);
        pwdLabel.setBounds(180, 60, 80, 20);
        codeLabel.setBounds(180, 100, 80, 20);
        usernameField.setBounds(260, 20, 160, 20);
        passwordField.setBounds(260, 60, 160, 20);
        codeField.setBounds(260, 100, 160, 20);
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
        buttonPanel.add(regButton);
        container.add(buttonPanel, "South");
        listener();

        // bkgPanel
        JLabel label = new JLabel();
        bkgPanel.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon(Constant.getImage("banner.png"));
        label.setIcon(img);
        bkgPanel.add(label);
        container.add(bkgPanel, "North");

    }

    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */
    private void listener(){
        loginButton.addActionListener(
                e -> {
                    user = usernameField.getText();
                    String pass = String.valueOf(passwordField.getPassword());
                    String code = String.valueOf(codeField.getPassword());
                    if (null == user
                            || user.trim().length() == 0
                            || pass.trim().length() == 0){
                        JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
                    } else {
                        try {
                            if (UserController.log_in(user, pass)){
                                JOptionPane.showMessageDialog(null, "Login Success!");
                                Constant.setCurrUsername(user);
                                Constant.setCurrUserType(UserController.getType(user));
                                new MainGUI();
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "Incorrect Credentials!");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
        );
        regButton.addActionListener(
                e -> new RegisterGUI()
        );

        clearButton.addActionListener(
                e -> {
                    usernameField.setText("");
                    passwordField.setText("");
                }
        );
    }
}
