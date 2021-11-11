package main.java.message;

import main.java.item.Item;


import java.util.Date;
import java.util.HashMap;

public class MessageForCustomer extends Message_R {

    public MessageForCustomer(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        super(item_list, order_date, order_id, order_status);
        this.content = "Dear Customer," + "\n" + " We are trying our best to process your order." + "\n" +
                "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status +
                "Thank you for your patience and have a nice day!" + message_date;

    }
}