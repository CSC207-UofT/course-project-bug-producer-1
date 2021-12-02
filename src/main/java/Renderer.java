package main.java;

import javax.swing.*;
import java.awt.*;

class Renderer extends DefaultListCellRenderer
{
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus)
    {
        JLabel lbl = (JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        if(list.getSelectedIndex() == index) lbl.setPreferredSize(new Dimension(100,75));
        else lbl.setPreferredSize(new Dimension(100,30));
        return lbl;
    }
}