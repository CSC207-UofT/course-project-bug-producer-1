package main.java.message;

import main.java.item.Item;
import main.java.order.Order;

import java.util.Date;
import java.util.HashMap;

public class SendMessageUseCase {

    public static String generate_message_for_customer(Order order) {
        HashMap<Item, Integer> item_list = order.get_item_list();
        Date order_date = order.get_date();
        String order_id = order.get_id();
        String order_status = order.get_status();
        MessageForCustomer message_instance = new MessageForCustomer(item_list, order_date, order_id, order_status);
        return message_instance.get_content();
    }

    public static String generate_message_for_admin(Order order) {
        HashMap<Item, Integer> item_list = order.get_item_list();
        Date order_date = order.get_date();
        String order_id = order.get_id();
        String order_status = order.get_status();
        MessageForAdmin message_instance = new MessageForAdmin(item_list, order_date, order_id, order_status);
        return message_instance.get_content();
    }
}