package main.java.user;

import java.util.ArrayList;

/**
 * A class used fot the register of users.
 */

public class RegisterUseCase {

    /**
     * Themethod is used to store the information of the user to register the user.
     * @param username The name of the user
     * @param secret_code The secret code needed to decide if the user is admin or customer.
     * @param user_input_secret_code The code entered by the user.
     * @param database The database used to store the information.
     * @return return a boolean type result, if the user register successfully, return true, else, return false.
     */
    public static boolean register(String username, String secret_code, String user_input_secret_code, Database database) {
        if(secret_code.equals(user_input_secret_code)) {
            ArrayList<String> info = new ArrayList<>();
            info.add(User.getUser_email());
            info.add(User.getPassword());
            info.add(User.getId());
            info.add(User.getType());
            database.database.put(username, info);
            return true;
        }
        return false;
    }
}
