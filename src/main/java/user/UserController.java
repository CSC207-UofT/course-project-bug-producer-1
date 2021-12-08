package user;


import user.useCase.GetCurrentUser;
import user.useCase.GetType;
import user.useCase.Log_inUseCase;
import user.useCase.UserReadWriter;

import java.io.IOException;
import java.util.ArrayList;




public class UserController {

    /**
     * A login controller for the use case defined by the Log_inUseCase
     */

    public static boolean log_in(String user_name, String user_pwd) throws IOException {
        return Log_inUseCase.login(user_name,user_pwd);
    }

    /**
     * A register controller for the use case defined by the RegisterUseCase
     */
    public static boolean register(String username, String user_input_secret_code, String password, String email) throws IOException {
        if (user_input_secret_code.equals("asd")){
            UserReadWriter.writeUsers(username,email,password, "admin");
        }
        else {
            UserReadWriter.writeUsers(username,email,password, "customer");
        }
        return true;
    }

    public static ArrayList<String> getCurrentUser (String name, String password, String secretCode) throws IOException{
        return GetCurrentUser.getCurrentUser(name,password,secretCode);
    }

    public static String getType (String name) throws IOException {
        return GetType.getType(name);
    }
}




