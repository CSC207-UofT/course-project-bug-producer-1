package gui;

import message.MessageController;

import javax.swing.*;
import java.awt.*;


public class AvalFrame extends JFrame {
    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;

    /**
     * Class constructor
     * Creates a new availability list panel inside the main program GUI window.
     * This method does not have any return type.
     */

    public AvalFrame(){
        setTitle("Order Detail");
        setBounds(150, 300, 150, 300);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        MessagePresenter.return_list_model_order_detail(listModel, )
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new FlowLayout());
        JLabel orderDetailLabel = new JLabel("Here is the latest available products");
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
