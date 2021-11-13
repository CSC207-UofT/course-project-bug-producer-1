package main.java.message;

import main.java.item.Item;


import java.util.Date;
import java.util.HashMap;

/**
 * This class is an entity class of the message sent to Customer. It is a subclass of Message_R.
 * It defines the format of the message shown to Customer when the customer place an order. This information pops up.
 * @author GEN LI
 */

public class MessageForCustomer extends Message_R {

    /**
     * This is the initiator of the MessageForCustomer class, which set the content of the MessageForCustomer to
     *
     * Dear Customer,
     * We are trying our best to process your order.
     * Order details: order_id
     * order_date
     * item_list
     * order_status
     * Thank you for your patience and have a nice day!
     * message_date
     *
     * It requires the item_list, order_date, order_id and order_status, which can be obtained from the order
     * by using the methods provided by the Order part.
     */

    public MessageForCustomer(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        super(item_list, order_date, order_id, order_status);
        this.content = "Dear Customer," + "\n" + " We are trying our best to process your order." + "\n" +
                "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status + "\n" +
                "Thank you for your patience and have a nice day!" + "\n" + message_date;

    }
}