package user;


public class Customer extends User {

    protected final String user_type;

    /**
     * Constructs an instance of User
     *
     * @param name       A string representing user's name.
     * @param pwd        A string representing user's password.
     * @param user_email A string representing user's email address.
     */
    public Customer(String name, String pwd, String user_email) {
        super(name, pwd, user_email);
        this.user_type = "Customer";
    }
}


