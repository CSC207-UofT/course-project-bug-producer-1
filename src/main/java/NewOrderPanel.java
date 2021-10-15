package main.java;

import main.java.order.OrderController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class NewOrderPanel extends JPanel {
    private static JButton newOrderButton = new JButton("Place new order");
    private static JLabel userOrderLabel = new JLabel("Enter item, separate by , ");
    private static JTextField OrderField = new JTextField();

    public NewOrderPanel(){
        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.DARK_GRAY);
        OrderField.setBounds(130, 20, 160, 20);
        orderPanel.add(userOrderLabel);
        orderPanel.add(OrderField);
        orderPanel.add(newOrderButton);
        this.add(orderPanel);
        listener();
    }

    private void listener(){
        newOrderButton.addActionListener(
                e -> {
                    String name = OrderField.getText();
                    System.out.println(OrderField.getText());
                    Date date = new Date();
                    System.out.println(date);
                    String customer_id = "000";
                    OrderController.generate_order(date, name, customer_id);
                    JOptionPane.showMessageDialog(null, "New Order Created! [WiP]");
                    String message_to_show = "Oreder Time: " + date + '\n' + "Item_name: " + name + '\n' + "Order ID: " + "000";

                    JOptionPane.showMessageDialog(null, message_to_show);



                }
        );



    }
}
