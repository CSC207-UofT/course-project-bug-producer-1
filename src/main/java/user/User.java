package main.java.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a User
 * @author Meilun Shen
 */

public abstract class User {
    protected static String name;
    protected static String user_email;
    protected static String password;
//    private final int user_id = 0;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    protected static String user_type;


    /**
     * Constructs an instance of User
     * @param user_name A string representing user's name.
     * @param user_email A string representing user's email address.
     * @param pwd A string representing user's password.
     */
    public User (String user_name, String pwd, String user_email, int user_id, String user_type){
        User.name = user_name;
        User.user_email = user_email;
        User.password = pwd;
        User.user_type = user_type;
//        User.user_id = user_id;

    }




//    /**
//     * Create an account.
//     * @param OlPassword A string representing the old password of the User's account.
//     * @param entered_password A string representing the new password of the User's account.
//     */
//    public void setPassword(String OlPassword, String entered_password){
//        if (authenticateUser (OlPassword)){
//            password = entered_password;
//        }
//    }
//    /**
//     * Verifies if the password entered by the User matches the saved password for authentication.
//     * @param entered_password A string representing the password that user entered to log in.
//     * @return true iff the saved password
//     */
//    public boolean authenticateUser(String entered_password){
//        if (password == null){
//            return true;
//        }
//        return password.equals(entered_password);
//    }


    /**
     * Gets the username of the User.
     * @return A string contains the username of the User.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the email address of the User.
     * @return A string contains the email address of the User.
     */
    public static String getUser_email(){
        return user_email;
    }

    /**
     * Gets the password of the User.
     * @return A string contains the saved password of the User.
     */
    public static String getPassword(){
        return password;
    }

    /**
     * Gets the auto-generated id of the User.
     * @return An AtomicInteger representing the id of the User.
     */
    public static String getId(){
        int id = id_generator.incrementAndGet();
        return String.valueOf(id);
    }

    public static String getType(){
        if (user_type == "admin"){
            return "admin";
        }
        else {
            return "customer";
        }
    }
}
