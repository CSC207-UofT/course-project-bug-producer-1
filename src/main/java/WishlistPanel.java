package main.java;

import javax.swing.*;
import java.awt.*;


public class WishlistPanel extends JPanel {
    private final JButton newItemButton = new JButton("Add new item to wish list");
    private final JTextField ItemField = new JTextField();

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

    private void listener(){
        newItemButton.addActionListener(
                e -> {
                    System.out.println(ItemField.getText());
                    JOptionPane.showMessageDialog(null, "New item added to the wish list! [WiP]");


                }
        );



    }
}
