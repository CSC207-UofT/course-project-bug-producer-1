package message;

import item.Item;
import message.useCase.list_model_add_elementUseCase;
import order.Order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is in charge of generating and returning messages seen by users in the UI, which only take in
 * the response from core program and process it, then return it to the UI for users.
 */
public class MessagePresenter {


    /**
     * This is a menthod that is used for generating and showing(print out) messages for Customers in the UI
     * when an order is placed successfully. The method can be called in the UI.
     *
     * @param message the parameter is the entity created by the MessageController.
     * @return return a Sting of the content of the message.
     */
    public static String print_out_message_for_customer(Message_R message) {
        return "Dear Customer," + "\n" + "Your order has been placed successfully! We are trying our best " +
                "to process your order !" + "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date() +
                "Thank you for your patience! Have a nice day!";
    }

    /**
     * This is a menthod that is used for generating and showing(print out) messages for Admin in the UI
     * when the admin requires to see the details of the order. The method can be called in the UI.
     *
     * @param message the parameter is the entity created by the MessageController.
     * @return return a Sting of the content of the message.
     */

    public static String print_out_message_for_Admin(Message_R message) {
        return "Dear Admin," + "\n" + "This order has been placed successfully by the customer!" +
                "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date();
    }

    /**
     * Return the data prepared for JList, which is used for scrolling the menu for customers to look browse.
     *
     * @param listmodel     a new DefaultListModel that will be processed (add element) in this method.
     * @param order_history a parameter that represents the order history which will be shown in the UI.
     */

    public static void return_list_model(DefaultListModel<String> listmodel, ArrayList<String[]> order_history) {
        for (String[] order : order_history) {
            list_model_add_elementUseCase.add_element_to_list_model(listmodel, order);
        }
    }

    /**
     * Return the data prepared for JList, which is used for scrolling the menu for customers to look browse in order detail.
     *
     * @param listmodel a new DefaultListModel that will be processed (add element) in this method.
     * @param order     a parameter that represents the order that the method is working on.
     */


    public static void return_list_model_order_detail(DefaultListModel<String> listmodel, Order order) {
        for (Map.Entry<Item, Integer> couple : order.get_item_list().entrySet()) {
            list_model_add_elementUseCase.add_element_to_order_detail_list_model(listmodel, couple.getKey().getName(), couple.getValue());
        }
    }

    /**
     * Return the data prepared for JList, which is used for scrolling the menu for customers to browse available goods in inventory.
     *
     * @param listmodel a new DefaultListModel that will be processed (add element) in this method.
     * @param goods     a HashMap type report of goods available in the inventory and their quantities.
     */

    public static void return_list_model_availability_list(DefaultListModel<String> listmodel, HashMap<String, Integer> goods) {
        for (String key : goods.keySet()) {
            list_model_add_elementUseCase.add_element_available_inventory_list_model(listmodel, key, goods.get(key));
        }
    }
}


