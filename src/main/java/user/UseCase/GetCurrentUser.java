package main.java.user.UseCase;

import java.io.IOException;


public class GetCurrentUser {

    /**
     * once the user has logged in successfully, this method gets his/her user information.
     *
     * @param name       A string representing username
     * @param password   A string representing password
     * @param secretCode A string representing secret code for verifying users' type
     * @return An Array of string containing the current user's information
     */
    public static String[] getCurrentUser(String name, String password, String secretCode) throws IOException {
        String [] s = new String[100];
        for (String[] registerUser : CurrentUReadWriter.readUsers()) {
            return registerUser;
        }
        return s;
    }
}