package main.java.message;

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
     * This is a method that is used for showing the popup notification when the email sent by users successfully.
     */
    public void print_success_notification_email(){
        System.out.println("The email has been sent successfully! Thank you!");
    }
}


