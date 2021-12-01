package main.java.message;




/**
 * This class
 */
public class MessagePresenter {

    public static void print_out_message_for_customer(Message_R message){
        String content = "Dear Customer," + "\n" + "Your order has been placed successfully! We are trying our best " +
                "to process your order !" + "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date() +
                "Thank you for your patience! Have a nice day!";
        System.out.println(content);
    }


    public static void print_out_message_for_Admin(Message_R message){
        String content = "Dear Admin," + "\n" + "This order has been placed successfully by the customer!" +
                 "\n" + "Order details:" + "\n" + "Order ID: " + message.get_order_id() + "\n" +
                "Items in the order: " + message.get_item_list() + "\n" + "Order status: " + message.get_status() + "\n" +
                "\n" + "Order date: " + message.get_order_date() + "\n" + "Message date: " + message.get_message_date();
        System.out.println(content);
    }

    public void print_success_notification_email(){
        System.out.println("The email has been sent successfully! Thank you!");
    }

    
}
// move message body here.


