package main.java.message;

import main.java.item.Item;
import main.java.message.UseCase.list_model_add_elementUseCase;
import main.java.order.Order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class is in charge of generating and returning messages seen by users in the UI, which only take in
 * the response from core program and process it, then return it to the UI for users.
 */
public class MessagePresenter {


    /**
     * This is a menthod that is used for generating and showing(print out) messages for Customers in the UI
     * when an order is placed successfully. The method can be called in the UI.
     * @param message the parameter is the entity created by the MessageController.
     */
    public static void print_out_message_for_customer(Message_R message){
        String content = "Dear Customer," + "\n" + "Your order has been placed successfully! We are trying our best " +
                "to process your order !" + "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date() +
                "Thank you for your patience! Have a nice day!";
        System.out.println(content);
    }

    /**
     * This is a menthod that is used for generating and showing(print out) messages for Admin in the UI
     * when the admin requires to see the details of the order. The method can be called in the UI.
     * @param message the parameter is the entity created by the MessageController.
     */

    public static void print_out_message_for_Admin(Message_R message){
        String content = "Dear Admin," + "\n" + "This order has been placed successfully by the customer!" +
                 "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date();
        System.out.println(content);
    }

    /**
     * Return the data prepared for JList, which is used for scrolling the menu for customers to look browse.
     * @param listmodel a new DefaultListModel that will be processed (add element) in this method.
     * @return return a DefaultListModel type variable that can be used by the UI to achieve the function of browsing.
     */
    public DefaultListModel<String> return_list_model(DefaultListModel<String> listmodel, ArrayList<String> order_history){
        for (String order : order_history){
            list_model_add_elementUseCase.add_element_to_list_model(listmodel, order);
        }

        return listmodel;
    }



    public DefaultListModel<String> return_list_model_orderdetail(DefaultListModel<String> listmodel, Order order){
        for (Map.Entry<Item, Integer> couple : order.get_item_list().entrySet()){
            list_model_add_elementUseCase.add_element_to_order_detail_list_model(listmodel, couple.getKey().getName(), couple.getValue());
        }
        return listmodel;
    }
    /**
     * This is a method that is used for showing the popup notification when the email sent by users successfully.
     */
    public void print_success_notification_email(){
        System.out.println("The email has been sent successfully! Thank you!");
    }
}

