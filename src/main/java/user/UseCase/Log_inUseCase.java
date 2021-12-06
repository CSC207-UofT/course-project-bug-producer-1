package main.java.user.UseCase;

import main.java.user.Admin;
import main.java.user.Customer;
import main.java.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Log_inUseCase {

    /**
     * Verifies whether the password entered by the User matches the saved password of the User.
     * @param name A string represents the entered username.
     * @param password A string represents the entered password.
     * @param user_input_secret_code A string contain secret code for differentiating user's type.
     * @return A hashmap contains information of the current logged-in user.
     */

    public static HashMap<Boolean, ArrayList<String>> login (String name, String password, String user_input_secret_code) throws IOException {
        HashMap<Boolean, ArrayList<String>> result = new HashMap<>();
        for (String[] registerUser : UserReadWriter.readUsers()) {
            String username = registerUser[0];
            String existPwd = registerUser[2];
            if (name.equals(username)) {
                if (password.equals(existPwd)){
                    User currentU;
                    if(user_input_secret_code.equals("asd")) {
                        currentU = new Admin(name, password, "");
                        ArrayList<String> helper = new ArrayList<>();
                        helper.add(currentU.getName());
                        helper.add(currentU.getType());
                        helper.add(currentU.getUser_email());
                        helper.add(currentU.getPassword());
                        result.put(true, helper);
                    }
                    else {
                        currentU = new Customer(name, password, "");
                        ArrayList<String> helper = new ArrayList<>();
                        helper.add(currentU.getName());
                        helper.add(currentU.getType());
                        helper.add(currentU.getUser_email());
                        helper.add(currentU.getPassword());
                        result.put(false, helper);
                    }
                }
                result.put(false, new ArrayList<>());
                return result;
            }
        }
        result.put(false, new ArrayList<>());
        return result;
    }
}


