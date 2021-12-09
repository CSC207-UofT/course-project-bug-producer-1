package gui;

import message.MessagePresenter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

import static gui.Constant.isAdmin;
import static order.order_history_controller.get_order_history_all;
import static order.order_history_controller.get_order_history_for_user;

/**
 * This is a JPanel class is the Order history class for GUI which handles
 * all the order history display
 * @author Walter
 */
public class OrderHistoryGUI extends JPanel
        implements ListSelectionListener {

    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;
    private static final String selectString = "Select";
    private static final String refreshString = "Refresh";
    private final JButton selectButton;
    private final JButton refreshButton;


    /**
     * Class constructor
     * Creates a new OrderHistory GUI panel.
     * This method does not have any return type.
     */
    public OrderHistoryGUI(){
        super(new BorderLayout());



        listModel = new DefaultListModel<>();
        loadListElements();
        //Create the itemlist and put it in a scroll pane.
        itemlist = new JList<>(listModel);
        itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemlist.setSelectedIndex(0);
        itemlist.addListSelectionListener(this);
        itemlist.setVisibleRowCount(10);

        JScrollPane listScrollPane = new JScrollPane(itemlist);
        listScrollPane.setPreferredSize(new Dimension(40, 400));

        refreshButton = new JButton(refreshString);
        refreshButton.setActionCommand(refreshString);
        refreshButton.setEnabled(true);




        selectButton = new JButton(selectString);
        selectButton.setActionCommand(selectString);
        selectButton.setEnabled(false);

        listener();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(selectButton);
        buttonPane.add(refreshButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel lblPane = new JPanel();
        lblPane.setLayout(new BoxLayout(lblPane,
                BoxLayout.LINE_AXIS));
        lblPane.add(new JLabel("Select an order to view detail: "));
        lblPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(lblPane, BorderLayout.PAGE_START);
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);



        itemlist.setCellRenderer(new myRenderer());



    }

    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */
    private void listener(){
        selectButton.addActionListener(
                e -> {
                    int size = listModel.getSize();
                    //Nobody's left, disable remove.
                    selectButton.setEnabled(size != 0);
                    int index = itemlist.getSelectedIndex();
                    String order_id = listModel.get(index).substring(16, 24);
                    new OrderDetailGUI(order_id);
                }
        );
        refreshButton.addActionListener(
                e -> loadListElements()
        );
    }
    /**
     * Helper function which help load all the list elements in the JList
     */
    private void loadListElements(){
        ArrayList<String[]> orderHis;
        listModel.removeAllElements();
        if (isAdmin()){
            orderHis = get_order_history_all();
        }else{
            orderHis = get_order_history_for_user(Constant.getCurrUsername());
        }
        MessagePresenter.return_list_model(listModel, orderHis);
    }
    /**
     * Helper function which help load all the list elements in the JList
     *
     * This method is required by ListSelectionListener.
     * @param e Listener even if something in the list get selected.
     */
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) itemlist.setCellRenderer(new myRenderer());
        if (!e.getValueIsAdjusting()) {

            //No selection, disable select button.
            //Selection, enable the select button.
            selectButton.setEnabled(itemlist.getSelectedIndex() != -1);
        }
    }
}
