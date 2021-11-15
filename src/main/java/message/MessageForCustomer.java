package main.java.message;

import main.java.item.Item;


import java.util.Date;
import java.util.HashMap;

/**
 * This class is an entity class of the message sent to Customer. It is a subclass of Message_R.
 * It defines the format of the message shown to Customer when the customer place an order. This information pops up.
 * @author GEN LI (Reagan)
 */

public class MessageForCustomer extends Message_R {

    /**
     * This method defines the message shown in a popup way for Customer when he/she place an order.
     * This is the initiator of the MessageForCustomer class, which set the content of the MessageForCustomer to

     * Dear Customer,
     * We are trying our best to process your order.
     * Order details: order_id
     * order_date
     * item_list
     * order_status
     * Thank you for your patience and have a nice day!
     * message_date
     *
     * @param item_list The list of items bought by the customer.
     * @param order_date The date when the order placed.
     * @param order_id The id of the order placed by the customer.
     * @param order_status The status of the order.
     */

    public MessageForCustomer(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        super(item_list, order_date, order_id, order_status);
        this.content = "Dear Customer," + "\n" + " We are trying our best to process your order." + "\n" +
                "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status + "\n" +
                "Thank you for your patience and have a nice day!" ;

    }
}