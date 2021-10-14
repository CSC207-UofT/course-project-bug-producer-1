package main.java.inventory;
import main.java.item.Item;
import main.java.inventory.InventoryController;

import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<String, Integer> item_list = new HashMap<String, Integer>();
    private HashMap<Integer, String> order_list = new HashMap<Integer, String>();
    public Inventory(int capacity, HashMap<String, Integer> item_list, HashMap<Integer, String> order_list){
        this.capacity = capacity;
        this.item_list = item_list;
        this.order_list = item_list;
    }
    public stock_in(HashMap<String, Integer> item_list, int num_in){
        int new_in_num = item_list.compute("",(key, value) -> value + num_in);
        return new_in_num;
    }
    /*should be void?*/
    public stock_out(HashMap<String, Integer> item_list, int num_out){
        int new_out_num = item_list.compute("",(key, value) -> value - num_out);
        return new_out_num;
    }

    public void send_update(){}

    }
}
