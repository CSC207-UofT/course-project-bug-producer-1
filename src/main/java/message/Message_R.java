package main.java.message;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;

public class Message_R {
    protected Date message_date = new Date();
    protected String content;

    public Message_R(HashMap<Item, Integer> item_list, Date order_date, String order_id, String order_status){
        this.content = null;
    }


    public String get_content(){
        return this.content;
    }
}
