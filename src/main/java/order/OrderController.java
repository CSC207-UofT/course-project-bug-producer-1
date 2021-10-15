package main.java.order;

import main.java.inventory.Inventory;
import main.java.item.Item;
import main.java.inventory.Inventory;

import java.util.Date;
import java.util.HashMap;

public class OrderController {

    public boolean review_order(Order order, Inventory inventory){
        HashMap<Item, Integer> inter = order.get_item_list();
        HashMap<Item, Integer> invenlst = inventory.get_item_list();
        for(Item key: inter.keySet()){
            if(inter.get(key) > invenlst.get(key)){
                order.up_date_status("refused");
                return false;
            }
        }
        order.up_date_status("processing");
        return true;
    }

    public Order Generate_order(Date date, HashMap<Item, Integer> item_list, String itemID, int customerID){
        return new Order(date, item_list, itemID, customerID);
    }
}
