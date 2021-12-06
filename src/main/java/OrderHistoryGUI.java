package main.java;

import main.java.message.MessagePresenter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static main.java.order.order_history_controller.get_order_history_for_user;


public class OrderHistoryGUI extends JPanel
        implements ListSelectionListener {

    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;
    private static final String selectString = "Select";
    private static final String refreshString = "Refresh";
    private final JButton selectButton;
    private final JButton refreshButton;



    public OrderHistoryGUI() throws IOException {
        super(new BorderLayout());



        listModel = new DefaultListModel<>();
        ArrayList<String[]> orderHis = get_order_history_for_user(Constant.getCurrUsername());
        MessagePresenter.return_list_model(listModel, orderHis);
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



        itemlist.setCellRenderer(new Renderer());



    }


    private void listener(){
        selectButton.addActionListener(
                e -> {
                    int size = listModel.getSize();
                    //Nobody's left, disable remove.
                    selectButton.setEnabled(size != 0);
                    int index = itemlist.getSelectedIndex();
                    String order_id = listModel.get(index).substring(16, 24);
                    try {
                        new OrderDetailGUI(order_id);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        refreshButton.addActionListener(
                e -> {
                    try {
                        listModel.removeAllElements();
                        ArrayList<String[]> orderHis = get_order_history_for_user(Constant.getCurrUsername());
                        MessagePresenter.return_list_model(listModel, orderHis);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
        );
    }


    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) itemlist.setCellRenderer(new Renderer());

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("NewOrderGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new OrderHistoryGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
