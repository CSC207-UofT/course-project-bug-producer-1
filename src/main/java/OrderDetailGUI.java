package main.java;

import javax.swing.*;
import java.awt.*;

public class OrderDetailGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel orderDetailLabel = new JLabel("Order Detail: ");

    public OrderDetailGUI(int order_id){
        setTitle("Order Detail");
        setBounds(800, 600, 800, 600);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
