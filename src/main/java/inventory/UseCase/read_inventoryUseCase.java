package inventory.UseCase;


import inventory.Inventory;
import item.ItemGateway;

import java.io.IOException;
import java.util.HashMap;

public class read_inventoryUseCase {
    public static Inventory read_inventory(){
        HashMap<String,Integer> item_inventory_create = new HashMap<>();
        try {
            item_inventory_create = ItemGateway.readItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Inventory(item_inventory_create);
    }
}
