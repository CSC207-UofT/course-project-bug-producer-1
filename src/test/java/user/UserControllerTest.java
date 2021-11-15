package java.user;

import main.java.user.Database;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static main.java.user.Log_inUseCase.log_in;
import static main.java.user.RegisterUseCase.register;
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

    @Test
    public void test_register(){
        Database database_S = new Database();
        ArrayList<String> list = new ArrayList<>();
        list.add("reagan.li@icloud.com");
        list.add("12345");
        list.add("1");
        list.add("Customer");
        database_S.database.put("Elva", list);
        boolean actual = register("Elva", "0000", "0000", database_S);
        Assert.assertTrue(database_S.database.containsKey("Elva"));
        Assert.assertTrue(actual);

    }

    @Test
    public void test_register_2(){
        Database database_S = new Database();
        ArrayList<String> list = new ArrayList<>();
        list.add("reagan.li@icloud.com");
        list.add("12345");
        list.add("1");
        list.add("Customer");
        database_S.database.put("Elva", list);
        boolean actual = register("Elva", "0000", "1111", database_S);
        Assert.assertFalse(database_S.database.containsKey("Elva"));
        Assert.assertFalse(actual);
    }

}
