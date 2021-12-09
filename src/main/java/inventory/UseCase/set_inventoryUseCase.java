package inventory.UseCase;

import inventory.Inventory;
import item.ItemGateway;
import item.useCase.ItemReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class set_inventoryUseCase {
    public static HashMap<String, Integer> set_inventory() throws IOException {
        HashMap<String, Integer> inventory_item_list;
        inventory_item_list = ItemGateway.readItems();
        return inventory_item_list;
    }
}
