package inventory;

import Database.ItemReadWriter;

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
     */
    public Inventory(HashMap<String, Integer> item_list) {
        this.item_list = item_list;
    }

    /**
     * this method is used to get the items in the inventory
     * @return return the list of the items in the inventory
     */
    public HashMap<String, Integer> get_item() throws IOException {
        set_inventory();
        return item_list;
    }
    private void set_inventory() throws IOException {
        this.item_list = ItemReadWriter.readItems();
    }
}


