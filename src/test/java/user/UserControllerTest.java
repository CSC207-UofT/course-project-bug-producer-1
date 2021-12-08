package java.user;

import org.junit.Before;
import user.UseCase.UserReadWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static user.UseCase.RegisterUseCase.register;
import static user.UserController.log_in;

public class UserControllerTest {

    // In case you run test cases more than one time, the initializer before test cases can help to empty the userdatabse.csv.
    // Otherwise, when running test cases twice without the initializer, the username "Reagan" will be registered twice and test cases will fail.


    @Before
    public void init() {
        File csv = new File("userdatabase.csv");
        if(csv.delete()){
            System.out.println("CSV File Deleted Successfully!!");
        }
        else{System.out.println("Failed to Delete the CSV File!!");}
    }



    @Test
    public void test_log_in() throws IOException {

        UserReadWriter.writeUsers("Elva", "reagan.li@icloud.com", "12345", "Customer");
        boolean actual = log_in("Elva", "12345");
        Assert.assertTrue(actual);

    }



    @Test
    public void test_register() throws IOException {

        //The database file "userdatabase.csv" need to be cleared. It should be empty.

        boolean actual = register("Reagan", "345.li@icloud.com", "12345", "admin");
        Assert.assertTrue(actual);

        //test for overlapping usernames
        boolean actual2 = register("Reagan", "123.li@icloud.com", "12345", "customer");
        Assert.assertFalse(actual2);
    }


}
