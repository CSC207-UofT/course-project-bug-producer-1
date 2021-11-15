package main.java.user;

public class Log_inUseCase {

    public static boolean log_in(String user_name, String user_pwd, Database database){
        return database.database.get(user_name).get(1).equals(user_pwd);

    }
}
