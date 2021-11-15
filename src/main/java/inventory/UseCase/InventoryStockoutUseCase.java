package main.java.inventory;

import main.java.item.Item;

import java.util.HashMap;

/**this class is an usecase class of the inventory
 * this class is uesed for stock out the item into the inventory
 * @author kurisu
 */
public class InventoryStockoutUseCase {
    /**
     * this method show how to stock in the item into the inventory
     * @param item_list a hash map that contains the item and the number of each item
     * @param num_out an int that show how much the item stock out
     * @param key_item an item param that show the key in the item hashmap
     * @return return a new hashmap of the inventory item after stock out
     */
    public static HashMap<Item, Integer> stock_out(HashMap<Item, Integer> item_list, int num_out, Item key_item) {
        int key_item_value = item_list.get(key_item);
        int item_in_num = key_item_value - num_out;
        item_list.putIfAbsent(key_item, item_in_num);
        return item_list;
    }
}
