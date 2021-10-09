package main.java;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame{
    private Container container = getContentPane();
    private static JButton orderButton = new JButton("New order");
    private static JButton hisButton = new JButton("Order History");
    private static JButton wlButton = new JButton("Wish list");
    private static JButton msgButton = new JButton("Messages");
    private static JButton exitButton = new JButton("Log out");

    public MainGUI(){
        setTitle("Bug-Producer Inventory System");
        setBounds(600, 200, 1024, 768);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);


    }

    private void init(){
        // ButtonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(orderButton);
        buttonPanel.add(hisButton);
        buttonPanel.add(wlButton);
        buttonPanel.add(msgButton);
        buttonPanel.add(exitButton);
        container.add(buttonPanel, "North");

        // bkg

        JPanel bkgPanel = new JPanel();
        JLabel label = new JLabel();

        bkgPanel.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("src/main/resources/bug.png");
        label.setIcon(img);
        bkgPanel.add(label);
        container.add(bkgPanel, "Center");

    }
}
