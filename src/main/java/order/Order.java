package main.java.order;
import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;

public class Order {

    private final Date date;
    private final String item_name;
//    private final String itemID;
    private String customerID;
    private String status;
    private String stocking;

    public Order(Date date,String item_name,String customerID){
        this.date = date;
        this.item_name = item_name;
//        this.itemID = itemID;
        this.customerID = customerID;
        this.status = "accepted";
    }

    public Date get_date(){
        return this.date;
    }

    public String get_item_name(){
        return this.item_name;
    }

//    public String get_id(){
//        return this.itemID;
//    }

    public String get_status(){
        return this.status;
    }

    public void up_date_status(String status){
        this.status = status;
    }
}
