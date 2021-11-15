package java.user;

import main.java.user.Database;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static main.java.user.Log_inUseCase.log_in;

public class UserControllerTest {
    @Test
    public void test_log_in(){
        Database database_S = new Database();
        ArrayList<String> list = new ArrayList<>();
        list.add("reagan.li@icloud.com");
        list.add("12345");
        list.add("1");
        list.add("Customer");
        database_S.database.put("Elva", list);
        boolean actual = log_in("Elva", "12345", database_S);
        Assert.assertTrue(actual);
    }

}
