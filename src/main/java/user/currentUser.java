package main.java.user;

/**
 * Represent the current User logged into the system.
 */

public class currentUser {

    protected User currentUser;

    /**
     * Constructs an instance of currentUser.
     * @param currentUser A User representing current user.
     */
    public void currentUser(User currentUser){
        this.currentUser = currentUser;
    }

    /**
     * Gets the current User logged into the system.
     * @return the current user
     */
    public User getCurrentUser(){
        return this.currentUser;
    }

    /**
     * Represents the current user by name, email address and type.
     * @return the name, email address and type separated by a comma
     */
    @Override
    public String toString(){
        return this.currentUser.getName() + "," + this.currentUser.getUser_email() + "," + this.currentUser.getType();
    }
}
