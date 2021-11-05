package main.java;

import javax.swing.*;
import java.awt.*;

public class MsgPanel extends JPanel {
    private final JButton newMsgButton = new JButton("New Message");
    private final JButton viewMsgButton = new JButton("View Message");

    public MsgPanel(){
        JPanel msgPanel = new JPanel();
        msgPanel.setBackground(Color.DARK_GRAY);
        msgPanel.add(newMsgButton);
        msgPanel.add(viewMsgButton);
        this.add(msgPanel);
        listener();
    }

    private void listener(){
        newMsgButton.addActionListener(
                e -> JOptionPane.showMessageDialog(null, "Create a new Message! [WiP]")
        );

        viewMsgButton.addActionListener(
                e -> JOptionPane.showMessageDialog(null, "You have no new Message!")
        );

    }
}
