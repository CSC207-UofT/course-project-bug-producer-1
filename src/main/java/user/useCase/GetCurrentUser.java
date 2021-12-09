package user.useCase;

import user.Admin;
import user.Customer;
import user.User;

import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class GetCurrentUser {

    /**
     * once the user has logged in successfully, this method gets his/her user information.
     *
     * @param name       A string representing username
     * @param password   A string representing password
     * @param secretCode A string representing secret code for verifying users' type
     * @return An Arraylist of the current user's information
     */
    public static ArrayList<String> getCurrentUser(String name, String password, String secretCode) throws IOException {
        ArrayList<String> helper = new ArrayList<>();

        for (String[] registerUser : UserReadWriter.readUsers()) {
            String username = registerUser[0];
            String existPwd = registerUser[2];
            if (name.equals(username)) {
                if (password.equals(existPwd)) {
                    User currentU;
                    if (secretCode.equals("asd")) {
                        currentU = new Admin(name, password, "");

                    } else {
                        currentU = new Customer(name, password, "");

                    }
                    helper.add(currentU.getName());
                    helper.add(currentU.getType());
                    helper.add(currentU.getUser_email());
                    helper.add(currentU.getPassword());
                    return helper;
                }
            }
        }
        return helper;
    }
}