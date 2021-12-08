package inventory.UseCase;


import inventory.Inventory;
import item.useCase.ItemReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class create_inventoryUseCase {
    public static Inventory create_inventory(){
        HashMap<String,Integer> item_inventory_create = null;
        try {
            item_inventory_create = ItemReadWriter.readItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Inventory(item_inventory_create);
    }
}
