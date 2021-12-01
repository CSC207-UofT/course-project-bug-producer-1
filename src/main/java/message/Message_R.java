package main.java.message;

import main.java.item.Item;
import main.java.order.Order;

import java.util.Date;
import java.util.HashMap;
/**
 * This class is an entity class of the message sent to customer or admin. It is a parent class. Its
 * subclasses are MessageForAdmin and MessageForCustomer.
 * @author GEN LI (Reagan)
 */

public class Message_R {
    protected final HashMap<Item, Integer> item_list;
    protected final Date order_date;
    protected final String id;
    protected final String status;
    protected Date message_date;

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

    public Message_R(Order order){
        this.item_list = order.get_item_list();
        this.order_date = order.get_date();
        this.id = order.get_id();
        this.status = order.get_status();
        this.message_date = new Date();


    }

    public HashMap<Item, Integer> get_item_list(){
        return this.item_list;
    }

    public Date get_order_date(){
        return this.order_date;
    }

    public String get_order_id(){
        return this.id;
    }

    public String get_status(){
        return this.status;
    }

    public Date get_message_date(){
        return this.message_date;
    }
}
