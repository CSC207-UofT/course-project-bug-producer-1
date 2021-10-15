package main.java;

import javax.swing.*;

public class MsgPanel extends JPanel {
    private final JButton newMsgButton = new JButton("New Message");

    public MsgPanel(){
        JPanel msgPanel = new JPanel();
        msgPanel.add(newMsgButton);
        listener();
    }

    private void listener(){
        newMsgButton.addActionListener(
                e -> {
                    JOptionPane.showMessageDialog(null, "Create new Message!");


                }
        );

    }
}
