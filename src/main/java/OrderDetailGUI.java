package main.java;

import main.java.message.MessageController;

import javax.swing.*;
import java.awt.*;

public class OrderDetailGUI extends JFrame {
    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;

    public OrderDetailGUI(String order_id){
        setTitle("Order Detail");
        setBounds(150, 200, 150, 150);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel labelPane = new JPanel();
        labelPane.setLayout(new FlowLayout());
        JLabel orderDetailLabel = new JLabel("Selected order detail");
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
