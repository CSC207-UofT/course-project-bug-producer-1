package main.java.inventory;

import main.java.Database.ItemReadWriter;
import main.java.item.Item;
import main.java.order.Order;

import java.io.IOException;
import java.util.HashMap;

/**
 * this class is a class of the inventory.
 * @author kurisu
 */

public class Inventory {
    private HashMap<String, Integer> item_list;

    /**
     * this method is the initiator of the Inventory
     * Used to view the item_list and order_list in the inventory, and the capacity of the inventory
     *
     *
     *
     */
    public Inventory(HashMap<String, Integer> item_list) {
        this.item_list = item_list;
    }

    /**
     * this method is used to get the items in the inventory
     *
     * @return return the list of the items in the inventory
     */
    public HashMap<String, Integer> get_item() throws IOException {
        set_inventory();
        return item_list;
    }
    //public HashMap<String, Integer> get_inventory_list() {
    //    set_inventory();
    //    HashMap<String, Integer> inventory_list = new HashMap<>();
    //    for (Item key : item_list.keySet()) {
    //        for (Integer value : item_list.values()) {
    //            inventory_list.put(key.toString(), value);
    //        }
    //    }
    //    return inventory_list;
    //}
    private void set_inventory() throws IOException {
        this.item_list = ItemReadWriter.readItems();
    }

}

