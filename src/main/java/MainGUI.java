package main.java;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame{
    private final Container container = getContentPane();
    private final JButton orderButton = new JButton("New order");
    private final JButton hisButton = new JButton("Order history [WiP]");
    private final JButton wlButton = new JButton("Wish list");
    private final JButton msgButton = new JButton("Messages");
    private final JButton exitButton = new JButton("Log out");
    private final JPanel bkgPanel = new JPanel();
    private final JPanel wlPanel = new WishlistPanel();
    private final JPanel orderPanel = new NewOrderPanel();
    // --Commented out by Inspection (2021-11-04, 10:06 p.m.):private final JPanel hisPanel = new JPanel();
    /**
     * Class constructor
     * Creates a new main program GUI window.
     * This method does not have any return type.
     */
    public MainGUI(){
        setTitle("Bug-Producer Inventory System");
        setBounds(600, 200, 1024, 768);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);

    }
    /**
     * Initialize the program
     * This method does not have any return type.
     *
     */
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

        // bkgPanel
        JLabel label = new JLabel();
        bkgPanel.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("src/main/resources/bug.png");
        label.setIcon(img);
        bkgPanel.add(label);
        container.add(bkgPanel, "Center");




        listener();


    }

    private void listener(){
        exitButton.addActionListener(
                e -> {
                    dispose();
                    JOptionPane.showMessageDialog(null, "You have logged off!");
                    new LoginGUI();

                }
        );

        msgButton.addActionListener(
                e -> {
                    new MailGUI();
                }
        );

        wlButton.addActionListener(
                e -> {
                    bkgPanel.removeAll();
                    bkgPanel.add(wlPanel);
                    bkgPanel.repaint();
                    bkgPanel.revalidate();
                }
        );

        orderButton.addActionListener(
                e -> {
                    bkgPanel.removeAll();
                    bkgPanel.add(orderPanel);
                    bkgPanel.repaint();
                    bkgPanel.revalidate();
                }
        );
    }
    public static void main(String[] args){
        new MainGUI();
    }

}
