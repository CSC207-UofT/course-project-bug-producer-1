package order;
import item.Item;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;
import java.util.HashMap;

public class Order_test {

    @Test
    public void test_get_total_item(){
        Date order_date = new Date();
        Item apple = new Item("apple", 1);
        HashMap<Item, Integer> item_list = new HashMap<>();
        item_list.put(apple, apple.getQuantity());
        Order order = new Order(item_list, "Processing");
        String actual = order.get_total_item();
        String expect = "1";
        Assert.assertEquals(expect, actual);

    }

    @Test
    public void test_get_status(){
        Date order_date = new Date();
        Item apple = new Item("apple", 1);
        HashMap<Item, Integer> item_list = new HashMap<>();
        item_list.put(apple, apple.getQuantity());
        Order order = new Order(item_list, "Processing");
        String actual = order.get_status();
        String expect = "Processing";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_get_item_list(){
        Date order_date = new Date();
        Item apple = new Item("apple", 1);
        HashMap<Item, Integer> item_list = new HashMap<>();
        item_list.put(apple, apple.getQuantity());
        Order order = new Order(item_list, "Processing");
        HashMap<Item, Integer> actual = order.get_item_list();
        HashMap<Item, Integer> expect = item_list;
        Assert.assertEquals(expect, actual);
    }

}
