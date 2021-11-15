package main.java.user;

import java.util.ArrayList;

public class RegisterUseCase {
    public static boolean register(String username, String secret_code, String user_input_secret_code, Database database) {
        if(secret_code.equals(user_input_secret_code)) {
            ArrayList<String> info = new ArrayList<>();
            info.add(User.getUser_email());
            info.add(User.getPassword());
            info.add(User.getId());
            info.add(User.getType());
            database.database.put(username, info);
            return true;
        }
        return false;
    }
}
