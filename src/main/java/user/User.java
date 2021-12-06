package user;

/**
 * Represents a User
 * @author Meilun Shen
 */

public class User {
    protected String name;
    protected String user_email;
    protected String password;
    protected String user_type;

    /**
     * Constructs an instance of User
     * @param name A string representing user's name.
     * @param user_email A string representing user's email address.
     * @param pwd A string representing user's password.
     */
    public User (String name, String user_email, String pwd){
        this.name = name;
        this.user_email = user_email;
        this.password = pwd;
        this.user_type = null;

    }

    /**
     * Gets the username of the User.
     * @return A string contains the username of the User.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the email address of the User.
     * @return A string contains the email address of the User.
     */
    public String getUser_email(){
        return this.user_email;
    }

    /**
     * Gets the password of the User.
     * @return A string contains the saved password of the User.
     */
    public String getPassword(){
        return this.password;
    }


    /**
     * Gets the type of User.
     * @return A string represents type of User.
     */

    public String getType() {
        return this.user_type;
    }


    /**
     * Represents users by their name, email address and password
     * @return the name, email address and password separated by a comma
     */
    @Override
    public String toString(){
        return this.name + "," + this.user_email + "," + this.password + "," + this.user_type;
    }

}
