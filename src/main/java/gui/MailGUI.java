package gui;

import javax.swing.*;
import java.awt.*;
/**
 * This class is the mailing class for GUI which handles
 * the mailing notification procedure.
 *
 * @author Walter
 */

public class MailGUI extends JFrame {
    private final Container container = getContentPane();
    private final JLabel receiveLabel = new JLabel("Receiver Address: ");
    private final JTextField receiveField = new JTextField();
    private final JLabel senderLabel = new JLabel("Sender Address: ");
    private final JTextField senderField = new JTextField();
    private final JTextField textField = new JTextField();
    private final JButton sendButton = new JButton("Send Now");


    /**
     * Class constructor
     * Creates a new Main program GUI window.
     * This method does not have any return type.
     */

    public MailGUI(){
        setIconImage(Constant.getImage("icon.png"));
        setTitle("Send Email");
        setBounds(800, 600, 800, 600);
        container.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
        setVisible(true);
    }


    /**
     * Initialize the program window
     * This method does not have any return type.
     *
     */
    private void init(){
        // FieldPanel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        receiveLabel.setBounds(50, 20, 150, 20);
        senderLabel.setBounds(50, 60, 150, 20);
        receiveField.setBounds(200, 20, 260, 20);
        senderField.setBounds(200, 60, 260, 20);
        textField.setBounds(50, 100, 700, 400);
        fieldPanel.add(receiveLabel);
        fieldPanel.add(senderLabel);
        fieldPanel.add(receiveField);
        fieldPanel.add(senderField);
        fieldPanel.add(textField);
        fieldPanel.add(sendButton);
        sendButton.setBounds(650, 30, 80, 50);
        container.add(fieldPanel, "Center");
        receiveField.setText("bugproducer207@gmail.com");
        
        listener();

    }
    /**
     * Class which contains the listener function allow the program to react according to the activities.
     *
     * This method does not have any return value.
     */
    private void listener(){
        sendButton.addActionListener(
                e -> {
                    String txt = textField.getText();
                    String send = senderField.getText();
                    String rec = receiveField.getText();
                    message.MessageController.send_mail(txt, send, rec);
                    JOptionPane.showMessageDialog(null, "Email Sent!");
                    dispose();
                }
        );

    }
}
