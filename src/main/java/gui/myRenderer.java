package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This is a customized DefaultListCellRenderer class for GUI which handles
 * all the place new order process
 * @author Walter
 */
class myRenderer extends DefaultListCellRenderer
{
    /**
     * Class constructor
     * Creates a new Order detail window.
     * @param list a JList class
     * @param index The index of selected cell in the list window
     * @param value The int value of that cell
     * @param isSelected The boolean variable indicates whether this cell is selected
     * @param cellHasFocus The boolean variable indicates whether this cell is selected
     * @return a Label
     */
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus)
    {
        JLabel lbl = (JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        if(list.getSelectedIndex() == index) lbl.setPreferredSize(new Dimension(100,75));
        else lbl.setPreferredSize(new Dimension(100,40));
        return lbl;
    }
}