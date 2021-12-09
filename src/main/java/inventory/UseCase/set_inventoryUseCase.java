package inventory.UseCase;

import item.Gateway;
import java.io.IOException;
import java.util.HashMap;

/**this class is an usecase class of the inventory
 * this class is uesed for set a inventory item list;
 * @author kurisu
 */
public class set_inventoryUseCase {
    /**
     * this method is used to create a hashmap of item in the inventory
     * @return a list for inventory item
     * @throws IOException
     */
    public static HashMap<String, Integer> set_inventory() throws IOException {
        HashMap<String, Integer> inventory_item_list;
        inventory_item_list = Gateway.readItems();
        return inventory_item_list;
    }
}
