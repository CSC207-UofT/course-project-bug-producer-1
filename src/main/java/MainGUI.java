package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private Container container = getContentPane();
    private static JButton orderButton = new JButton("New order");
    private static JButton hisButton = new JButton("Order history");
    private static JButton wlButton = new JButton("Wish list");
    private static JButton msgButton = new JButton("Messages");
    private static JButton exitButton = new JButton("Log out");
    private static JButton newOrderButton = new JButton("Place new order");
    private static JLabel userOrderLabel = new JLabel("Enter item, separate by , ");
    private static JTextField OrderField = new JTextField();
    private final JPanel msgPanel = new MsgPanel();
    private final JPanel bkgPanel = new JPanel();
    private final JPanel wlPanel = new JPanel();
    private final JPanel orderPanel = new JPanel();
    private JPanel hisPanel = new JPanel();

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

        // bkgPanel
        JLabel label = new JLabel();
        bkgPanel.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("src/main/resources/bug.png");
        label.setIcon(img);
        bkgPanel.add(label);
        container.add(bkgPanel, "Center");
        orderPanel.add(userOrderLabel);
        orderPanel.add(OrderField);
        orderPanel.add(newOrderButton);



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
                    bkgPanel.removeAll();
                    bkgPanel.add(msgPanel);
                    bkgPanel.repaint();
                    bkgPanel.revalidate();
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
