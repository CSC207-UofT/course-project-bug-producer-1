package java.user;

import main.java.user.UseCase.UserReadWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static main.java.user.UseCase.GetCurrentUser.getCurrentUser;
import static main.java.user.UseCase.RegisterUseCase.register;
import static main.java.user.UserController.log_in;

public class UserControllerTest {
    @Test
    public void test_log_in() throws IOException {

        UserReadWriter.writeUsers("Elva", "reagan.li@icloud.com", "12345", "Customer");
        boolean actual = log_in("Elva", "12345");
        Assert.assertTrue(actual);
        ArrayList<String> s = new ArrayList<>();
        s.add("Elva");
        s.add("Customer");
        s.add("reagan.li@icloud.com");
        s.add("12345");

        ArrayList<String> actual_list = getCurrentUser ("Elva", "12345", "gsdi");
        Assert.assertEquals(actual_list, s);

        ArrayList<String> s_2 = new ArrayList<>();
        s.add("Reagan");
        s.add("Admin");
        s.add("reagan.li@icloud.com");
        s.add("12345");

        ArrayList<String> actual_list_2 = getCurrentUser ("Reagan", "12345", "asd");
        Assert.assertEquals(actual_list, s_2);
    }



    @Test
    public void test_register() throws IOException {

        boolean actual = register("Elva", "0000", "12345", "123.li@icloud.com");
        Assert.assertTrue(actual);

        //test for overlapping usernames
        boolean actual2 = register("Elva", "bug", "12345", "123.li@icloud.com");
        Assert.assertFalse(actual2);
    }


}
