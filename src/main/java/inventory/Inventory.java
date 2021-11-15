package main.java.inventory;

import main.java.item.Item;

import java.util.HashMap;

/**
 * this class is a class of the inventory.
 * @author kurisu
 */

public class Inventory {
    private final int capacity;
    public static final HashMap<Item, Integer> item_list = new HashMap<>();
    private HashMap<Item, Integer> order_list = new HashMap<>();
    /**
    * this method is the initiator of the Inventory
    * Used to view the item_list and order_list in the inventory, and the capacity of the inventory
    * @param capacity the capacity of the inventory
    * @param order_list show the order that the inventory need to be done
     */
    public Inventory(int capacity, HashMap<Item, Integer> order_list){
        this.capacity = capacity;
        this.order_list = order_list;
    }

    /**
     *this method is used to get the items in the inventory
     * @return return the list of the items in the inventory
     */
    public static HashMap<Item, Integer> get_item_list() {
        return item_list;
    }
    /**
     *this method is used to get the order in the inventory
     * @return return the list of the order in the inventory
     */
    public HashMap<Item, Integer> get_orders_list() {
        return this.order_list;
    }
    /**
     *this method is used to get the capacity of the inventory
     * @return return the value of the capacity of the inventory
     */
    public int get_capacity() {
        return capacity;
    }
}

