package main.java;

import main.java.order.OrderController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class NewOrderPanel extends JPanel {
    private final JButton newOrderButton = new JButton("Place new order");
    private final JTextField OrderField = new JTextField();

    public NewOrderPanel(){
        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.DARK_GRAY);
        OrderField.setBounds(130, 20, 160, 20);
        JLabel userOrderLabel = new JLabel("Enter item, separate by , ");
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
                    String customer_id = LoginGUI.getUsername();
                    OrderController.generate_order(date, name, customer_id);
                    JOptionPane.showMessageDialog(null, "New Order Created! [WiP]");
                    String message_to_show = "Order Time: " + date + '\n' + "Customer ID: " + customer_id + '\n' +
                            "Item_name: " + name + '\n' + "Order ID: " + "000";
                    OrderField.setText("");
                    JOptionPane.showMessageDialog(null, message_to_show);



                }
        );



    }
}
