package main.java.message;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;
/**
 * This class is an entity class of the message sent to customer or admin. It is a parent class. Its
 * subclasses are MessageForAdmin and MessageForCustomer.
 * @author GEN LI
 */

public class Message_R {
    protected Date message_date = new Date();
    protected String content;
    /**
     * This method is the initiator of the Message_R, which set the content of the message to null.
     *
     * This kind of message is for the popup feedback of order for customer and the feedback of order
     * for admin when he/she require to see the order details.
     *
     * It requires the item_list, order_date, order_id and order_status, which can be obtained from the order
     * by using the methods provided by the Order part.
     */

    public Message_R(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        this.content = null;
    }

    /**
     * This method return the content of the message. It is a method that is needed by the subclassses.
     * This method does not require parameter.
     */

    public String get_content(){
        return this.content;
    }
}
