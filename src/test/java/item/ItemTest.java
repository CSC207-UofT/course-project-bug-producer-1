package item;


import item.Item;
import order.Order;

import org.junit.*;

import java.io.*;
import java.util.Date;
import java.util.HashMap;

public class ItemTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public String[] getMainOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
//        Item.main(null);

        System.setOut(originalOut);

        return bos.toString().split("\n");
    }
    @Test
    public void test_getName(){
        Item apple = new Item("apple", 1);
        String actual = apple.getName();
        String expect = "apple";
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void test_getName2(){
        Item apple = new Item("banana", 1);
        String actual = apple.getName();
        String expect = "banana";
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void test_getQuantity(){
        Item apple = new Item("apple", 1);
        int actual = apple.getQuantity();
        int expect = 1;
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void test_getQuantity2(){
        Item apple = new Item("apple", 100);
        int actual = apple.getQuantity();
        int expect = 100;
        Assert.assertEquals(expect, actual);
    }


}
