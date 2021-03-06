package user.useCase;

import java.io.IOException;


public class RegisterUseCase {

    /**
     * Checks if given username is taken by any other user or not and adds a User object to the database,
     * * given the name, username and usertype
     *
     * @param name       A string represents the username
     * @param user_email A string represents the user's email
     * @param pwd        A string represents the user's password
     * @param type       A string represents the user's type
     * @return true indicating registration success, otherwise return false.
     */
    public static boolean register(String name, String user_email, String pwd, String type) throws IOException {
        if (!UserReadWriter.readUsers().isEmpty()) {
            for (String[] registerUser : UserReadWriter.readUsers()) {
                String username = registerUser[0];

                if (name.equals(username)) {
                    return false;
                } else {
                    UserReadWriter.writeUsers(name, user_email, pwd, type);
                    return true;
                }
            }
            return false;
        } else {
            UserReadWriter.writeUsers(name, user_email, pwd, type);
            return true;
        }
    }
}

