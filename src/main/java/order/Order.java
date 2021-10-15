package main.java.order;
import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;

public class Order {

    private final Date date;
    private final HashMap<Item, Integer> item_list;
    private final String itemID;
    private int customerID;
    private String status;
    private String stocking;

    public Order(Date date,HashMap<Item, Integer> item_list,String itemID,int customerID){
        this.date = date;
        this.item_list = item_list;
        this.itemID = itemID;
        this.customerID = customerID;
        this.status = "accepted";
    }

    public Date get_date(){
        return this.date;
    }

    public HashMap<Item, Integer> get_item_list(){
        return this.item_list;
    }

    public String get_id(){
        return this.itemID;
    }

    public String get_status(){
        return this.status;
    }

    public void up_date_status(String status){
        this.status = status;
    }
}
