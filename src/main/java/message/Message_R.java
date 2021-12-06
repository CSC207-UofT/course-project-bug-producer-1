package main.java.message;

import main.java.item.Item;
import main.java.order.Order;

import java.util.Date;
import java.util.HashMap;
/**
 * This class is an entity class of the popup message sent to customer or admin.
 * @author GEN LI (Reagan)
 */

public class Message_R {
    protected final HashMap<Item, Integer> item_list;
    protected final Date order_date;
    protected final String id;
    protected final String status;
    protected final Date message_date;

    /**
     * This method is the initiator of the Message_R, which set the content of the message to null.
     * This kind of message is for the popup feedback of order for customer and the feedback of order
     * for admin when he/she require to see the order details.
     *
     * @param order The order that the message is related to.
     */


    public Message_R(Order order){
        this.item_list = order.get_item_list();
        this.order_date = order.get_date();
        this.id = order.get_id();
        this.status = order.get_status();
        this.message_date = new Date();


    }

    /**
     * This is a method that is used to get the item_list stored in the order entity.
     * @return the method returns a HashMap of items required in the order.
     */

    public HashMap<Item, Integer> get_item_list(){
        return this.item_list;
    }

    /**
     * This is a method that is used to get the date of order stored in the order entity.
     * @return the method returns a Date type variable of date of the order.
     */

    public Date get_order_date(){
        return this.order_date;
    }

    /**
     * This is a method that is used to get the order id of the order.
     * @return the method returns a String of order_id.
     */

    public String get_order_id(){
        return this.id;
    }

    /**
     * This is a method that is used to get the status of the order.
     * @return the method returns a String of status of the order.
     */

    public String get_status(){
        return this.status;
    }

    /**
     * This is a method that is used to get the generated date of the order.
     * @return the method returns a Date type variable of order's date of generating.
     */

    public Date get_message_date(){
        return this.message_date;
    }
}
