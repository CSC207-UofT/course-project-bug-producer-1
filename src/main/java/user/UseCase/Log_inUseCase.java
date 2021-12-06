package main.java.user.UseCase;

import main.java.user.Admin;
import main.java.user.Customer;
import main.java.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Log_inUseCase {

    /**
     * Verifies whether the password entered by the User matches the saved password of the User.
     * @param name A string represents the entered username.
     * @param password A string represents the entered password.
     * @return true for logging in successfully
     */

    public static boolean login (String name, String password) throws IOException {
        for (String[] registerUser : UserReadWriter.readUsers()) {
            String username = registerUser[0];
            String existPwd = registerUser[1];
            if (name.equals(username)) {
                return password.equals(existPwd);
                }
            return false;
            }
        return false;
        }
    }



