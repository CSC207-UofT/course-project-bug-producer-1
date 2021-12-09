package gui;

import message.MessageController;
import message.MessagePresenter;

import static order.order_history_controller.find_order;

import javax.swing.*;
import java.awt.*;
/**
 * This is a JFrame class is the OrderDetail class for GUI which handles
 * all the Order detail
 * @author Walter
 */
public class OrderDetailGUI extends JFrame {
    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;

    /**
     * Class constructor
     * Creates a new Order detail window.
     * This method does not have any return type.
     */
    public OrderDetailGUI(String order_id){
        setIconImage(Constant.getImage("icon.png"));
        setTitle("Order Detail");
        setBounds(150, 200, 150, 150);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        listModel = MessageController.create_new_list_model();
        MessagePresenter.return_list_model_order_detail(listModel, find_order(order_id));
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new FlowLayout());
        JLabel orderDetailLabel = new JLabel("Selected order detail");
        labelPane.add(orderDetailLabel);


        JPanel listPane = new JPanel();
        listPane.setLayout(new FlowLayout());
        //Create the itemlist and put it in a scroll pane.
        itemlist = new JList<>(listModel);
        itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemlist.setSelectedIndex(0);
        itemlist.setVisibleRowCount(10);

        JScrollPane listScrollPane = new JScrollPane(itemlist);


        container.add(labelPane, BorderLayout.PAGE_START);
        container.add(listScrollPane, BorderLayout.CENTER);

    }
}
