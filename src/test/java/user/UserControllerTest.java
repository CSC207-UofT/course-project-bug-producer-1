package user;

import user.UseCase.UserReadWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static user.UseCase.RegisterUseCase.register;
import static user.UserController.log_in;

public class UserControllerTest {
//    @Test
//    public void test_log_in() throws IOException {
//
//        UserReadWriter.writeUsers("Elva", "reagan.li@icloud.com", "12345", "Customer");
//        boolean actual = log_in("Elva", "12345");
//        Assert.assertTrue(actual);
//
//    }
//
//
//
//    @Test
//    public void test_register() throws IOException {
//
//        //The database file "userdatabase.csv" need to be cleared. It should be empty.
//
//        boolean actual = register("Elva", "345.li@icloud.com", "12345", "admin");
//        Assert.assertTrue(actual);
//
//        //test for overlapping usernames
//        boolean actual2 = register("Elva", "123.li@icloud.com", "12345", "customer");
//        Assert.assertFalse(actual2);
//    }


}
