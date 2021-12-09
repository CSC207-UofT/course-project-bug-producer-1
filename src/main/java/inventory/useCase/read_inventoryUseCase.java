package inventory.useCase;


import inventory.Inventory;
import item.Gateway;

import java.io.IOException;
import java.util.HashMap;

/**this class is an usecase class of the inventory
 * this class is used for read item in the database and create a new inventory
 * @author kurisu
 */
public class read_inventoryUseCase {
    /**
     * this method is used to read item in the database and create a new inventory
     * @return a new inventory
     */
    public static Inventory read_inventory(){
        HashMap<String,Integer> item_inventory_create = new HashMap<>();
        try {
            item_inventory_create = Gateway.readItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Inventory(item_inventory_create);
    }
}
