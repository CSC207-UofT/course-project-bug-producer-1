package main.java.user;

/**
 * This class is used to create a database that can store the information of Users.
 */

public class Create_DatabaseUseCase {

    /**
     * This is a method used to create the database.
     * @return return a Database type database.
     */
    public Database create_database(){
        return new Database();
    }

}
