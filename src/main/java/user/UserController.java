package main.java.user;

import main.java.user.UseCase.RegisterUseCase;

/**
 * This is a class used to control the action of the User.
 */

public class UserController {

    /**
     * This is a method for logging in the user account.
     * @param user_name User's register name.
     * @param user_pwd User's password.
     * @param database The database store the User information.
     * @return return a boolean type result, if login successfully, return true, else, return false.
     */
    public static boolean log_in(String user_name, String user_pwd, Database database){
        return main.java.user.Log_inUseCase.log_in(user_name, user_pwd, database);
    }

    /**
     * This is a method for registering the user account.
     * @param username User's register name.
     * @param secret_code The secret code needed to decide if the user is admin or customer.
     * @param user_input_secret_code The code entered by the user.
     * @param database The database used to store the information.
     * @return return a boolean type result, if register successfully, return true, else, return false.
     */

    public static boolean register(String username, String secret_code, String user_input_secret_code, Database database){
        return RegisterUseCase.register(username, secret_code, user_input_secret_code, database);

    }

}




