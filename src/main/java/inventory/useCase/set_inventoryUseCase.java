package inventory.useCase;

import item.Gateway;
import java.io.IOException;
import java.util.HashMap;

/**this class is an Usecase class of the inventory
 * this class is used for set an inventory item list;
 * @author kurisu
 */
public class set_inventoryUseCase {
    /**
     * this method is used to create a hashmap of item in the inventory
     * @return a list for inventory item
     * @throws IOException File not found description
     */
    public static HashMap<String, Integer> set_inventory() throws IOException {
        HashMap<String, Integer> inventory_item_list;
        inventory_item_list = Gateway.readItems();
        return inventory_item_list;
    }
}
