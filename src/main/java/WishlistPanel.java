package main.java;

import javax.swing.*;
import java.awt.*;


public class WishlistPanel extends JPanel {
    private final JButton newItemButton = new JButton("Add new item to wish list");
    private final JTextField ItemField = new JTextField();

    /**
     * Class constructor
     * Creates a new wish list panel inside the main program GUI window.
     * This method does not have any return type.
     */

    public WishlistPanel(){
        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.DARK_GRAY);
        JLabel userItemLabel = new JLabel("Enter item, separate by , ");
        orderPanel.add(userItemLabel);
        orderPanel.add(ItemField);
        orderPanel.add(newItemButton);
        this.add(orderPanel);
        listener();
    }
    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */
    private void listener(){
        newItemButton.addActionListener(
                e -> {
                    System.out.println(ItemField.getText());
                    JOptionPane.showMessageDialog(null, "New item added to the wish list! [WiP]");
                }
        );



    }
}
