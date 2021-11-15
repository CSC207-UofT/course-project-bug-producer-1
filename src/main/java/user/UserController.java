package main.java.user;



public class UserController {
    public boolean log_in(String user_name, String user_pwd, Database database){
        return Log_inUseCase.log_in(user_name, user_pwd, database);
    }

    public boolean register(String username, String secret_code, String user_input_secret_code, Database database){
        return RegisterUseCase.register(username, secret_code, user_input_secret_code, database);

    }

}




