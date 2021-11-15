package main.java.user;

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
    public boolean log_in(String user_name, String user_pwd, Database database){
        return Log_inUseCase.log_in(user_name, user_pwd, database);
    }

    /**
     * This is a method for registering the user account.
     * @param username User's register name.
     * @param user_input_secret_code The code entered by the user.
     * @param database The database used to store the information.
     * @return return a boolean type result, if register successfully, return true, else, return false.
     */

    public boolean register(String username, String user_input_secret_code, Database database, String password, String email){
        return RegisterUseCase.register(username, user_input_secret_code, database, password, email);

    }

}




