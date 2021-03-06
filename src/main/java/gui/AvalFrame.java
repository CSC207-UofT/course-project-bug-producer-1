package gui;

import message.MessageController;
import message.MessagePresenter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import static inventory.InventoryController.*;

/**
 * A JFrame class responsible for availability list frame.
 * @author Walter
 */
public class AvalFrame extends JFrame {
    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;
    private static final String refreshString = "Refresh";
    private final JButton refreshButton;

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
        JLabel orderDetailLabel = new JLabel("Available products");
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

        refreshButton = new JButton(refreshString);
        refreshButton.setActionCommand(refreshString);
        refreshButton.setEnabled(true);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout());
        buttonPane.add(refreshButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JScrollPane listScrollPane = new JScrollPane(itemlist);
        loadListElements();

        container.add(labelPane, BorderLayout.PAGE_START);
        container.add(listScrollPane, BorderLayout.CENTER);
        container.add(buttonPane, BorderLayout.PAGE_END);
        listener();
    }
    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */

    private void listener(){

        refreshButton.addActionListener(
                e -> loadListElements()
        );
    }

    /**
     * Helper function which help load all the list elements in the JList
     */

    private void loadListElements(){
        listModel.removeAllElements();
        HashMap<String, Integer> avalItem = generate_report();
        MessagePresenter.return_list_model_availability_list(listModel, avalItem);
    }




}
