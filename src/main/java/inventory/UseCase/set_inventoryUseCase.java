package inventory.UseCase;

import item.Gateway;
import java.io.IOException;
import java.util.HashMap;

public class set_inventoryUseCase {
    public static HashMap<String, Integer> set_inventory() throws IOException {
        HashMap<String, Integer> inventory_item_list;
        inventory_item_list = Gateway.readItems();
        return inventory_item_list;
    }
}
