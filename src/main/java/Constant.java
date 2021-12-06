package main.java;

import main.java.user.User;

public class Constant {
    public static String currentUser = "";
    public static final String version = "1.3.1";

    public Constant(){
    }

    public static void setCurrUser(String user){
        currentUser = user;
    }

    public static String getCurrUser(){
        return currentUser;
    }
}


