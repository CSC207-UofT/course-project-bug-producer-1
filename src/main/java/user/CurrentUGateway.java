package main.java.user;

import main.java.user.UseCase.CurrentUReadWriter;
import main.java.user.UseCase.GetCurrentUser;


import java.io.IOException;
import java.util.ArrayList;

public abstract class CurrentUGateway {

    /**
     * CurrentUGateway serves as a bridge between the database storing information of current user and the actual
     * information of the current user
     */

    public static void writeUsers(String name, String user_email, String pwd, String type) throws IOException {
        CurrentUReadWriter.writeUsers(name,user_email,pwd,type);

    }

    public static ArrayList<String[]> readUsers() throws IOException {
        return CurrentUReadWriter.readUsers();
    }

    public static String[] getCurrentUser(String name, String password, String secretCode) throws IOException{
        return GetCurrentUser.getCurrentUser(name, password, secretCode);
    }
}
