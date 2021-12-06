package java.user;

import main.java.user.UseCase.UserReadWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static main.java.user.UseCase.RegisterUseCase.register;
import static main.java.user.UserController.log_in;

public class UserControllerTest {
    @Test
    public void test_log_in() throws IOException {

        UserReadWriter.writeUsers("Elva", "reagan.li@icloud.com", "12345", "Customer");
        HashMap<Boolean, ArrayList<String>> actual = log_in("Elva", "12345", "asd");
        Assert.assertTrue(actual.containsKey(true));
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
