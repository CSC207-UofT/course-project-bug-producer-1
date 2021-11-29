package main.java;

import main.java.user.Database;
import main.java.user.UseCase.Create_DatabaseUseCase;


public class GUI {
    /**
     * Class constructor
     * This method does not have any return type.
     */
    public static Database dat;
//    public static DefaultListModel listModel;
//    public static JList itemlist;
    public GUI(){
//        listModel = new DefaultListModel();
//        itemlist = new JList(listModel);
    }
    /**
     * Class constructor
     * This method creates a new  loginGUI window which starts the program.
     */
    public static void main(String[] args){
        dat = Create_DatabaseUseCase.create_database();
        new LoginGUI();
    }
}
