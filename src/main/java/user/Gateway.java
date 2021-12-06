package main.java.user;

import main.java.user.UseCase.UserReadWriter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Gateway controls the interaction between database and use cases (log in and register).
 */
public class Gateway {


    public static void writeUsers(String name, String user_email, String pwd, String type) throws IOException {
        UserReadWriter.writeUsers(name,user_email,pwd,type);

    }

    public static ArrayList<String[]> readUsers() throws IOException {
        return UserReadWriter.readUsers();
    }
}
