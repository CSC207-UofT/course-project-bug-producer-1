package main.java.inventory.UseCase;

import main.java.item.Item;

import java.util.HashMap;

/**this class is an usecase class of the inventory
 * this class is uesed for stock in the item into the inventory
 * @author kurisu
 */
public class InventoryStockinUseCase {
    /**
     * this method show how to stock in the item into the inventory
     * @param item_list a hash map that contains the item and the number of each item
     * @param num_in an int that show how much the item stock in
     * @param key_item an item param that show the key in the item hashmap
     * @return return a new hashmap of the inventory item after stock in
     */
    public static HashMap<Item, Integer> stock_in(HashMap<Item, Integer> item_list, int num_in, Item key_item) {
        int key_item_value = item_list.get(key_item);
        int item_in_num = key_item_value + num_in;
        item_list.putIfAbsent(key_item, item_in_num);
        return item_list;
    }
}
