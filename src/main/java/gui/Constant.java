package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Constant {
    public static String currentUsername;
    public static String currrentUserType;
    public static final String version = "1.3.1";

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

    public static ImageIcon getIcon(final String pathAndFileName){
        return new ImageIcon(pathAndFileName);
    }

}


