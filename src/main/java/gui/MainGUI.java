package gui;

import order.OrderController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static gui.Constant.*;

/**
 * This class is the main class for GUI which handles
 * and represents other panels and connects to other GUIs
 *
 * @author Yuehao Huang
 */

public class MainGUI extends JFrame{
    private final Container container = getContentPane();
    private final JButton orderButton = new JButton("New order");
    private final JButton hisButton = new JButton("Order history");
    private final JButton wlButton = new JButton("Availability list");
    private final JButton msgButton = new JButton("Messages");
    private final JButton exitButton = new JButton("Log out");
    private final JPanel submitOrderPanel = new JPanel();
    private final JButton submitOrderButton = new JButton("Submit Order");
    private final JPanel bkgPanel = new JPanel();
    private final NewOrderGUI orderPanel = new NewOrderGUI();
    private final JPanel hisPanel = new OrderHistoryGUI();


    /**
     * Class constructor
     * Creates a new main program GUI window.
     * This method does not have any return type.
     */
    public MainGUI() {
        setIconImage(Constant.getImage("icon.png"));
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
        submitOrderPanel.add(submitOrderButton);

        // bkgPanel
        JLabel label = new JLabel();
        bkgPanel.setLayout(new GridLayout(0, 1));
        ImageIcon img = new ImageIcon(getImage("bug.png"));
        label.setIcon(img);
        bkgPanel.add(label);
        container.add(bkgPanel, "Center");


        listener();


    }

    private void listener(){
        exitButton.addActionListener(
                e -> {
                    initialize();
                    dispose();
                    JOptionPane.showMessageDialog(null, "You have logged off!");
                    new LoginGUI();

                }
        );

        msgButton.addActionListener(
                e -> new MailGUI()
        );

        wlButton.addActionListener(
                e -> new AvalFrame()
        );

        orderButton.addActionListener(
                e -> {
                    bkgPanel.removeAll();
                    bkgPanel.add(orderPanel);
                    bkgPanel.add(submitOrderPanel);
                    bkgPanel.repaint();
                    bkgPanel.revalidate();
                }
        );
        hisButton.addActionListener(
                e -> {
                    bkgPanel.removeAll();
                    bkgPanel.add(hisPanel);
                    bkgPanel.repaint();
                    bkgPanel.revalidate();
                }
        );
        submitOrderButton.addActionListener(
                e -> {
                    String user = getCurrUsername();
                    if (NewOrderGUI.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Order cannot be empty!");
                    }else{
                        try {
                            String ordername = orderPanel.getOrder();
                            if (isAdmin()){
                                OrderController.generate_order_from_GUI_admin(ordername);
                                JOptionPane.showMessageDialog(null, "Order restocked!");
                            }else{
                                OrderController.generate_order_from_GUI(ordername, user);
                                JOptionPane.showMessageDialog(null, "Order submitted!");
                            }
                            System.out.println(ordername);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }

                }
        );
    }
    public static void main(String[] args){
        new MainGUI();
    }

}
