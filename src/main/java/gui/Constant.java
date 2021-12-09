package gui;

import java.awt.*;
import java.net.URL;
/**
 * A class responsible for storing all the constants when user logins.
 * @author Walter
 */
public class Constant {
    private static String currentUsername;
    private static String currrentUserType;

    /**
     * Set username and currentUserType to empty String.
     */
    public static void initialize(){
        setCurrUserType("");
        setCurrUsername("");
    }
    /**
     * Set username to variable type.
     * @param type A string of current user type.
     */
    public static void setCurrUserType(String type){
        currrentUserType = type;
    }

    /**
     * Set username to variable user.
     * @param user A string of current username.
     */
    public static void setCurrUsername(String user){
        currentUsername = user;
    }

    /**
     * this method returns the current username.
     * @return String which indicates the current username.
     */
    public static String getCurrUsername(){
        return currentUsername;
    }

    /**
     * this method returns the current user type
     * @return boolean which indicates whether current user is Admin or not.
     */
    public static boolean isAdmin(){
        return currrentUserType.equals("admin");
    }


    /**
     * This method return the image of certain path.
     * @param pathAndFileName A string of path and filename
     * @return boolean which indicates whether current user is Admin or not.
     */
    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}


