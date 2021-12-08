package inventory.UseCase;

import inventory.Inventory;
import item.useCase.ItemReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class set_inventoryUseCase {
    public static HashMap<String, Integer> set_inventory(Inventory inventory) throws IOException {
        HashMap<String, Integer> inventory_item_list;
        inventory_item_list = ItemReadWriter.readItems();
        return inventory_item_list;
    }
}
