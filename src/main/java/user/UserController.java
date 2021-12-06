package main.java.user;

import main.java.user.UseCase.Log_inUseCase;
import main.java.user.UseCase.RegisterUseCase;

import java.io.IOException;


public class UserController {

    /**
     * A login controller for the use case defined by the Log_inUseCase
     */

    public static boolean log_in(String user_name, String user_pwd, String secretCode) throws IOException {
        return Log_inUseCase.login(user_name, user_pwd, secretCode);
    }

    /**
     * A register controller for the use case defined by the RegisterUseCase
     */
    public static boolean register_controller (String username, String user_input_secret_code, String password, String email) throws IOException {
        if (user_input_secret_code.equals("asd")){
            RegisterUseCase.register(username,email,password, "admin");
        }
        else {
            RegisterUseCase.register(username,email,password, "customer");
        }
        return true;
    }

}




