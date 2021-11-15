package test.java.message;

import main.java.item.Item;
import main.java.item.Apple;
import main.java.item.Beef;
import main.java.message.SendMessageUseCase;
import main.java.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

public class Test_for_message {
    @Test
    public void test_generate_message_for_customer(){
        Date order_date = new Date();
        HashMap<Item, Integer> item_list = new HashMap<>();
        Item apple = new Apple("apple",123, 1, 3);
        item_list.put(apple, apple.getQuantity());

        Order order = new Order(order_date, item_list, "Processing");

        String order_id = order.get_id();
        String order_status = order.get_status();

        String expect = "Dear Customer," + "\n" + " We are trying our best to process your order." + "\n" +
                "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status +
                "Thank you for your patience and have a nice day!";
        String actual = SendMessageUseCase.generate_message_for_customer(order);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_generate_message_for_admin(){
        Date order_date = new Date();
        HashMap<Item, Integer> item_list = new HashMap<>();
        Item beef = new Beef("Beef",987,2,4);
        item_list.put(beef, beef.getQuantity());

        Order order = new Order(order_date, item_list, "Processing");

        String order_id = order.get_id();
        String order_status = order.get_status();

        String expect = "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" +
                order_status;
        String actual = SendMessageUseCase.generate_message_for_customer(order);
        Assert.assertEquals(expect, actual);
    }
}
