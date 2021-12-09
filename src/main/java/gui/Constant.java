package gui;

import inventory.Inventory;
import inventory.InventoryController;

import java.awt.*;
import java.net.URL;

public class Constant {
    private static String currentUsername;
    private static String currrentUserType;


    public Constant(){
        initialize();
    }

    public static void initialize(){
        setCurrUserType("");
        setCurrUsername("");
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




    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}


