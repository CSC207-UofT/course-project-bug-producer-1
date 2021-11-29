package test.java.item;

import main.java.item.Item;
import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;

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

    @Test(timeout = 50)
    public void testgetName(){
        Item sample = new Item("Vegetables", 5, 6);
        assertEquals("Vegetables", sample.getName());
    }

    @Test(timeout = 50)
    public void testgetCapacity(){
        Item sample = new Item("Vegetables", 5, 6);
        assertEquals(5, sample.getCapacity());
    }

    @Test(timeout = 50)
    public void testgetQuantity(){
        Item sample = new Item("Vegetables", 5, 6);
        assertEquals(6, sample.getQuantity());
    }
}
