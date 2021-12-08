package user;


import user.useCase.*;

import java.io.IOException;
import java.util.ArrayList;


public class UserController {

    /**
     * A controller for the method called login defined by the Log_inUseCase class
     */

    public static boolean log_in(String user_name, String user_pwd) throws IOException {
        return Log_inUseCase.login(user_name, user_pwd);
    }

    /**
     * A controller for the method called register defined by the RegisterUseCase class
     */
    public static boolean register(String username, String user_input_secret_code, String password, String email) throws IOException {
        boolean result;
        if (user_input_secret_code.equals("asd")) {
            result = RegisterUseCase.register(username, email, password, "admin");
        } else {
            result = RegisterUseCase.register(username, email, password, "customer");
        }
        return result;
    }

    /**
     * A Controller for the method called getCurrentUser defined by the GetCurrentUser class
     */
    public static ArrayList<String> getCurrentUser(String name, String password, String secretCode) throws IOException {
        return GetCurrentUser.getCurrentUser(name, password, secretCode);
    }

    /**
     * A controller for the method called getType defined by the GetType class.
     */
    public static String getType(String name) throws IOException {
        return GetType.getType(name);
    }
}




