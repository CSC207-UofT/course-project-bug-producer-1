package user.useCase;


import java.io.IOException;

public class GetType {

    /**
     * Get users' type based on their username
     * @param name A string representing the user's type
     * @return if the entered username matches the saved username in the database, this method returns the
     *         user's type. Otherwise, this method return a string "not found".
     */

    public static String getType (String name) throws IOException {
        for (String[] registerUser : user.useCase.UserReadWriter.readUsers()) {
            String username = registerUser[0];
            if (name.equals(username)) {
                return registerUser[3];
            }
        }
        return "not found";
    }
}
