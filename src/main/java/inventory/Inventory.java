package main.java.inventory;

import main.java.item.Item;
import main.java.inventory.InventoryController;
import main.java.order.Order;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<Item, Integer> item_list ;
    private ArrayList<Order> order_list;

    public Inventory(int capacity, HashMap<Item, Integer> item_list,ArrayList<Order> order_list){
        this.capacity = capacity;
        this.item_list = item_list;
        this.order_list = order_list;
    }

    public HashMap<Item, Integer> get_item_list(){
        return this.item_list;
    }

    public ArrayList<Order> get_order_list(){
        return this.order_list;
    }

    public int get_capacity(){
        return this.capacity;
    }
}
