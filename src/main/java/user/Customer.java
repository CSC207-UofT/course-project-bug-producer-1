package main.java.user;

public class Customer extends User {

    /**
     * Constructs an instance of User
     *
     * @param user_name  A string representing user's name.
     * @param pwd        A string representing user's password.
     * @param user_email A string representing user's email address.
     * @param user_id  An int representing the user's specific id.
     * @param user_type The user's type.
     */
    public Customer(java.lang.String user_name, java.lang.String pwd, java.lang.String user_email, int user_id, java.lang.String user_type) {
        super(user_name, pwd, user_email, user_id, user_type);
    }
}

