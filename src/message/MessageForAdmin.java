package main.java.message;

import main.java.item.Item;


import java.util.Date;
import java.util.HashMap;

public class MessageForAdmin extends main.java.message.Message {

    public MessageForAdmin(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        super(item_list, order_date, order_id, order_status);
        this.content = "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status + message_date;

    }
}
