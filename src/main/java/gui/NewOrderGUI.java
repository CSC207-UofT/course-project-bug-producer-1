package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a JPanel class is the New Order class for GUI which handles
 * all the place new order process
 * @author Walter
 */
public class NewOrderGUI extends JPanel
        implements ListSelectionListener {

    public static DefaultListModel<String> listModel;
    public static JList<String> itemlist;
    private static final String addString = "Add";
    private static final String removeString = "Remove";
    private final JButton removeButton;
    private final JTextField itemName;
    private final JTextField itemAmount;
    private String oderItem;

    /**
     * Class constructor
     * Creates a new Order GUI window.
     * This method does not have any return type.
     */
    public NewOrderGUI() {
        super(new BorderLayout());
        this.oderItem = "";

        listModel = new DefaultListModel<>();


        //Create the itemlist and put it in a scroll pane.
        itemlist = new JList<>(listModel);
        itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemlist.setSelectedIndex(0);
        itemlist.addListSelectionListener(this);
        itemlist.setVisibleRowCount(10);
        itemlist.setCellRenderer(new myRenderer());
        JScrollPane listScrollPane = new JScrollPane(itemlist);
        

        JButton addButton = new JButton(addString);
        AddListener AddListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(AddListener);
        addButton.setEnabled(false);

        removeButton = new JButton(removeString);
        removeButton.setActionCommand(removeString);
        removeButton.setEnabled(false);
        removeButton.addActionListener(new RemoveListener());

        itemName = new JTextField(10);
        itemName.addActionListener(AddListener);
        itemName.getDocument().addDocumentListener(AddListener);

        itemAmount = new JTextField(3);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(removeButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JLabel("Amount: "));
        buttonPane.add(itemAmount);

        itemName.setText("Item Name");

        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


        JPanel buttonPane1 = new JPanel();
        buttonPane1.setLayout(new BoxLayout(buttonPane1,
                BoxLayout.LINE_AXIS));
        buttonPane1.add(addButton);
        buttonPane1.add(Box.createHorizontalStrut(5));
        buttonPane1.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane1.add(Box.createHorizontalStrut(5));
        buttonPane1.add(new JLabel("Item: "));
        buttonPane1.add(itemName);

        itemAmount.setText("1");
        buttonPane1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(listScrollPane, BorderLayout.CENTER);

        JPanel ControlButtonPane = new JPanel();
        ControlButtonPane.setLayout(new GridLayout(2, 1));

        ControlButtonPane.add(buttonPane, BorderLayout.PAGE_END);
        ControlButtonPane.add(buttonPane1, BorderLayout.PAGE_END);
        add(ControlButtonPane, BorderLayout.PAGE_END);



    }
    
    public static boolean isEmpty(){
        int size = listModel.getSize();
        return size == 0;
    }

    public String getOrder() {
        return this.oderItem;
    }

    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = itemlist.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();
            oderItem = listModel.toString();

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

    //This listener is shared by the text field and the Add button.
    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private final JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = itemName.getText();
            String num = itemAmount.getText();
            num = num.replaceFirst("^0+(?!$)", "");
            //remove leading 0 in the string

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name + " | " + num)) {
                Toolkit.getDefaultToolkit().beep();
                itemName.requestFocusInWindow();
                itemName.selectAll();
                return;
            }

            try{
                if (num.equals("0")){
                    JOptionPane.showMessageDialog(itemAmount, "Amount cannot be 0!");
                    return;
                }
                int number = Integer.parseInt(num);
            }
            catch (NumberFormatException ex){

                if (num.isEmpty()){
                    JOptionPane.showMessageDialog(itemAmount, "Amount cannot be empty!");
                }else{
                    JOptionPane.showMessageDialog(itemAmount, "Only Integers allowed when inputting amount!");
                }

                return;
            }

            int index = itemlist.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }

            //If we just wanted to add to the end, we'd do this:

            listModel.addElement(name + " | " + num);

            oderItem = listModel.toString().replaceAll(", ", " .");

            //Reset the text field.
            itemName.requestFocusInWindow();
            itemName.setText("");
            itemAmount.setText("");

            //Select the new item and make it visible.
            itemlist.setSelectedIndex(index);
            itemlist.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) itemlist.setCellRenderer(new myRenderer());
        if (!e.getValueIsAdjusting()) {

            //No selection, disable remove button.
            //Selection, enable the remove button.
            removeButton.setEnabled(itemlist.getSelectedIndex() != -1);
        }
    }

}