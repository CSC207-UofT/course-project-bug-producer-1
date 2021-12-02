package main.java;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderHistoryGUI extends JPanel
        implements ListSelectionListener {

    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;
    private static final String removeString = "Remove";
    private static final String selectString = "Select";
    private final JButton removeButton;
    private final JButton selectButton;



    public OrderHistoryGUI() {
        super(new BorderLayout());

        listModel = new DefaultListModel<>();


        //Create the itemlist and put it in a scroll pane.
        itemlist = new JList<>(listModel);
        itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemlist.setSelectedIndex(0);
        itemlist.addListSelectionListener(this);
        itemlist.setVisibleRowCount(10);

        JScrollPane listScrollPane = new JScrollPane(itemlist);
        listScrollPane.setPreferredSize(new Dimension(40, 400));



        removeButton = new JButton(removeString);
        removeButton.setActionCommand(removeString);
        removeButton.addActionListener(new RemoveListener());
        removeButton.setEnabled(false);

        selectButton = new JButton(selectString);
        selectButton.setActionCommand(selectString);
        selectButton.setEnabled(false);

        listener();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(selectButton);
        buttonPane.add(removeButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel lblPane = new JPanel();
        lblPane.setLayout(new BoxLayout(lblPane,
                BoxLayout.LINE_AXIS));
        lblPane.add(new JLabel("Select an order to view detail: "));
        lblPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(lblPane, BorderLayout.PAGE_START);
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
        listModel.addElement("<html>Order ID: 001<br/>Order time: 2021/01/03<br/>Order items: 17</html>");
        listModel.addElement("<html>Order ID: 001<br/>Order time: 2021/01/03<br/>Order items: 17</html>");

        itemlist.setCellRenderer(new Renderer());



    }


    private void listener(){
        selectButton.addActionListener(
                e -> {
                    int size = listModel.getSize();
                    if (size == 0) { //Nobody's left, disable remove.
                        selectButton.setEnabled(false);

                    }else{
                        selectButton.setEnabled(true);
                    }
                    int index = itemlist.getSelectedIndex();
                    String order = listModel.get(index).substring(16, 18);
                    int order_id = Integer.parseInt(order);
                    new OrderDetailGUI(order_id);
                }
        );
    }

    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = itemlist.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable remove.
                removeButton.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                itemlist.setSelectedIndex(index);
                itemlist.ensureIndexIsVisible(index);
            }
        }
    }


    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) itemlist.setCellRenderer(new Renderer());
        if (!e.getValueIsAdjusting()) {
            //Selection, enable the remove button.
            removeButton.setEnabled(itemlist.getSelectedIndex() != -1);
            selectButton.setEnabled(itemlist.getSelectedIndex() != -1);
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
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
        SwingUtilities.invokeLater(OrderHistoryGUI::createAndShowGUI);
    }
}
