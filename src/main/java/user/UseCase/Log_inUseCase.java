package main.java.user.UseCase;


import java.io.IOException;


public class Log_inUseCase {

    /**
     * Verifies whether the password entered by the User matches the saved password of the User.
     * @param name A string represents the entered username.
     * @param password A string represents the entered password.
     * @param secretCode A String represents the secretCode for verifying user's type
     * @return true for logging in successfully
     */

    public static boolean login (String name, String password, String secretCode) throws IOException {
        if (secretCode.equals("asd")) {
            CurrentUReadWriter.writeUsers(name, "", password, "admin");
        }
        else {
            CurrentUReadWriter.writeUsers(name, "", password, "customer");
        }
        for (String[] registerUser : UserReadWriter.readUsers()) {
            String username = registerUser[0];
            String existPwd = registerUser[2];
            if (name.equals(username)) {
                return password.equals(existPwd);
                }
            return false;
            }
        return false;
        }
    }



