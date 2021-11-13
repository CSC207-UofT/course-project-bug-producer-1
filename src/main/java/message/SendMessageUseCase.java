package main.java.message;

import main.java.item.Item;
import main.java.order.Order;

import java.util.Date;
import java.util.HashMap;

/**
 * This class is an UseCase class of the message sent to customer or admin. This kind of message is for the popup
 * feedback of order for customer and the feedback of order for admin when he/she require to see the order details.
 * This class is used for generate message for Customer and Admin.
 * @author GEN LI
 */

public class SendMessageUseCase {

    /**
     * This method is used for the generation of the message for Customer.
     * It returns a String, whose content is the content needed for Customer.
     * It requires an order as its parameter.
     */

    public static String generate_message_for_customer(Order order) {
        HashMap<Item, Integer> item_list = order.get_item_list();
        Date order_date = order.get_date();
        String order_id = order.get_id();
        String order_status = order.get_status();
        MessageForCustomer message_instance = new MessageForCustomer(item_list, order_date, order_id, order_status);
        return message_instance.get_content();
    }

    /**
     * This method is used for the generation of the message for Admin.
     * It returns a String, whose content is the content needed for Admin.
     * It requires an order as its parameter.
     */

    public static String generate_message_for_admin(Order order) {
        HashMap<Item, Integer> item_list = order.get_item_list();
        Date order_date = order.get_date();
        String order_id = order.get_id();
        String order_status = order.get_status();
        MessageForAdmin message_instance = new MessageForAdmin(item_list, order_date, order_id, order_status);
        return message_instance.get_content();
    }
}