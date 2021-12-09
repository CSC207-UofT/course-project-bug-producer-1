package inventory;


import java.util.HashMap;
/**
 * this class is a class of the inventory.
 * @author kurisu
 */
public class Inventory {
    protected HashMap<String, Integer> item_list;

    /**
     * this method is the initiator of the Inventory
     * Used to view the item_list in the inventory
     */
    public Inventory(HashMap<String, Integer> list) {
        this.item_list = list;
    }

    /**
     * this method is used to get the items in the inventory
     * @return return the list of the items in the inventory
     */
    public HashMap<String, Integer> get_item() {
        return item_list;
    }
}


