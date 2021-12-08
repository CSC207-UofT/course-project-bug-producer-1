package inventory.UseCase;


import inventory.Inventory;
import item.useCase.ItemReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class create_inventoryUseCase {
    public static Inventory create_inventory() throws IOException {
        HashMap<String,Integer> item_inventory_create = ItemReadWriter.readItems();
        return new Inventory(item_inventory_create);
    }
}
