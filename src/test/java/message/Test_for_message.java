package message;

import item.Item;
import order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static message.MessagePresenter.print_out_message_for_Admin;
import static message.MessagePresenter.print_out_message_for_customer;
import static message.MessageController.create_message_R;

public class Test_for_message {
    @Test
    public void test_SendMessageUseCase_and_MessagePresenter_controller_customer(){
        Date order_date = new Date();
        Item apple = new Item("apple", 1);
        HashMap<Item, Integer> item_list = new HashMap<>();
        item_list.put(apple, apple.getQuantity());

        Order order = new Order(item_list, "Processing");

        Message_R message = create_message_R(order);

        String expect = "Dear Customer," + "\n" + "Your order has been placed successfully! We are trying our best " +
                "to process your order !" + "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date() +
                "Thank you for your patience! Have a nice day!";
        String actual = print_out_message_for_customer(message);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_SendMessageUseCase_and_MessagePresenter_controller_admin(){
        Date order_date = new Date();
        Item apple = new Item("apple", 1);
        HashMap<Item, Integer> item_list = new HashMap<>();
        item_list.put(apple, apple.getQuantity());

        Order order = new Order(item_list, "Processing");

        Message_R message = create_message_R(order);

        String expect = "Dear Admin," + "\n" + "This order has been placed successfully by the customer!" +
                "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date();
        String actual = print_out_message_for_Admin(message);
        Assert.assertEquals(expect, actual);
    }
}
