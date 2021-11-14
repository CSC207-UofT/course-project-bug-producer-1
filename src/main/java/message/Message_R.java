package main.java.message;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;
/**
 * This class is an entity class of the message sent to customer or admin. It is a parent class. Its
 * subclasses are MessageForAdmin and MessageForCustomer.
 * @author GEN LI (Reagan)
 */

public class Message_R {
    protected Date message_date = new Date();
    protected String content;

    /**
     * This method is the initiator of the Message_R, which set the content of the message to null.
     * This kind of message is for the popup feedback of order for customer and the feedback of order
     * for admin when he/she require to see the order details.
     *
     * @param item_list The list of items bought by the customer.
     * @param order_date The date when the order placed.
     * @param order_id The id of the order placed by the customer.
     * @param order_status The status of the order.
     */

    public Message_R(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        this.content = null;
    }


    /**
     * It is a method that is needed by the subclasses, which provide the content of the message generated for users.
     * @return it returns the content of the message.
     */

    public String get_content(){
        return this.content;
    }
}
