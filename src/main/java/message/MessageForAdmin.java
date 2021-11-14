package main.java.message;

import main.java.item.Item;


import java.util.Date;
import java.util.HashMap;

/**
 * This class is an entity class of the message sent to Admin. It is a subclass of Message_R.
 * It defines the format of the message shown to admin when the admin requires to view the order details.
 * @author GEN LI
 */

public class MessageForAdmin extends Message_R {

    /**
     * This is the initiator of the MessageForAdmin class, which set the content of the MessageForAdmin to
     *
     * Order details: order_id
     * order_date
     * item_list
     * order_status
     *
     * It requires the item_list, order_date, order_id and order_status, which can be obtained from the order
     * by using the methods provided by the Order part.
     */
    public MessageForAdmin(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        super(item_list, order_date, order_id, order_status);
        this.content = "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" +
                order_status + message_date;

    }
}
