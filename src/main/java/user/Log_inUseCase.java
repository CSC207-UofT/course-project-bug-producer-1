package main.java.user;

/**
 * This class is used for the login of users.
 */

public class Log_inUseCase {

    /**
     * This method is used for the log_in of users. It checks if the password entered by the user
     * matches the password stored in thr database
     * @param user_name The name of the user. A String.
     * @param user_pwd  A string that represents the password of the user.
     * @param database The database that store the information of user's name and passwords etc.
     * @return reture a boolean type result, if matches, return true, otherwise, return false.
     */

    public static boolean log_in(String user_name, String user_pwd, Database database){
        return database.database.get(user_name).get(1).equals(user_pwd);

    }
}
