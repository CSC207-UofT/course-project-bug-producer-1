package gui;

public class Constant {
    public static String currentUsername = "";
    public static final String version = "1.3.1";

    public Constant(){
    }

    public static void setCurrUsername(String user){
        currentUsername = user;
    }

    public static String getCurrUsername(){
        return currentUsername;
    }
}


