package inventory.UseCase;


import inventory.Inventory;
import item.Gateway;

import java.io.IOException;
import java.util.HashMap;

public class read_inventoryUseCase {
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
