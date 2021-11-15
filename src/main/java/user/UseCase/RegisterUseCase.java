package main.java.user.UseCase;

import main.java.user.Database;
import main.java.user.User;

import java.util.ArrayList;

/**
 * A class used fot the register of users.
 */

public class RegisterUseCase {

    /**
     * Themethod is used to store the information of the user to register the user.
     * @param username The name of the user
     * @param user_input_secret_code The code entered by the user.
     * @param database The database used to store the information.
     * @param password Password of the user
     * @param email email of the user
     * @return return a boolean type result, if the user register successfully, return true, else, return false.
     */
    public static boolean register(String username, String user_input_secret_code, Database database, String password, String email) {
        String secret_code = "bug";
        if(secret_code.equals(user_input_secret_code)) {
            ArrayList<String> info = new ArrayList<>();
            info.add(email);
            info.add(password);
//            info.add(User.getId());
            info.add("Admin");
            database.database.put(username, info);
            return true;
        }

        else{
            ArrayList<String> info = new ArrayList<>();
            info.add(email);
            info.add(password);
//            info.add(User.getId());
            info.add("Customer");
            database.database.put(username, info);
            return true;

        }
    }
}
