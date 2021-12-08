package gui;

import inventory.Inventory;
import inventory.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Constant {
    private static String currentUsername;
    private static String currrentUserType;
    private static Inventory inv;


    public Constant(){
        initialize();
    }

    public static void initialize(){
        setCurrUserType("");
        setCurrUsername("");
        newInv();
    }

    public static void setCurrUserType(String type){
        currrentUserType = type;
    }

    public static void setCurrUsername(String user){
        currentUsername = user;
    }

    public static String getCurrUsername(){
        return currentUsername;
    }

    public static boolean isAdmin(){
        return currrentUserType.equals("admin");
    }

    public static void newInv(){
        inv = InventoryController.generate_create_inventory();
    }
    public static Inventory getInv(){
        return inv;
    }



    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}


