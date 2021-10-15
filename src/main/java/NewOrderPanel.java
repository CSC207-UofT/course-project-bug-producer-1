package main.java;

import main.java.order.OrderController;

import javax.swing.*;
import java.awt.*;

public class NewOrderPanel extends JPanel {
    private static JButton newOrderButton = new JButton("Place new order");
    private static JLabel userOrderLabel = new JLabel("Enter item, separate by , ");
    private static JTextField OrderField = new JTextField();

    public NewOrderPanel(){
        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.DARK_GRAY);
        orderPanel.add(userOrderLabel);
        orderPanel.add(OrderField);
        orderPanel.add(newOrderButton);
        this.add(orderPanel);
        listener();
    }

    private void listener(){
        newOrderButton.addActionListener(
                e -> {
                    System.out.println(OrderField.getText());
//                    OrderController.Generate_order();
                    JOptionPane.showMessageDialog(null, "New Order Created! [WiP]");


                }
        );



    }
}
