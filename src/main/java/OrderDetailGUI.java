package main.java;

import main.java.message.MessageController;
import main.java.message.MessagePresenter;
import main.java.order.OrderController;

import javax.swing.*;
import java.awt.*;

public class OrderDetailGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel orderDetailLabel = new JLabel("Selected order detail");
    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;

    public OrderDetailGUI(String order_id){
        setTitle("Order Detail");
        setBounds(150, 200, 150, 150);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        listModel = OrderController.getOrder(order_id);
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new FlowLayout());
        labelPane.add(orderDetailLabel);

        listModel = MessageController.create_new_list_model();
//        listModel = MessagePresenter.return_list_model_order_detail(listModel, order);
        JPanel listPane = new JPanel();
        listPane.setLayout(new FlowLayout());
        //Create the itemlist and put it in a scroll pane.
        itemlist = new JList<>(listModel);
        itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemlist.setSelectedIndex(0);
        itemlist.setVisibleRowCount(10);

        JScrollPane listScrollPane = new JScrollPane(itemlist);
        listModel.addElement("Item A | 16");
        listModel.addElement("Item B | 3");
        listModel.addElement("Item C | 4");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");
        listModel.addElement("Item D | 1");

        container.add(labelPane, BorderLayout.PAGE_START);
        container.add(listScrollPane, BorderLayout.CENTER);

    }
}
