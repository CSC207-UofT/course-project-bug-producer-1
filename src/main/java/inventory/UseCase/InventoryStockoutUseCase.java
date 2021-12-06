package inventory.UseCase;

import main.java.Database.ItemReadWriter;
import inventory.Inventory;
import main.java.order.Order;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**this class is an usecase class of the inventory
 * this class is uesed for stock out the item into the inventory
 * @author kurisu
 */
public class InventoryStockoutUseCase {
    /**
     * this method show how to stock out the item into the inventory
     * @param order get the order list and the number of the item need stock out
     * @param inventory get the item in the inventory
     * @return return a new hashmap of the inventory item after stock out
     */
    public static HashMap<String, Integer> stock_out(Order order, Inventory inventory) throws IOException {
        HashMap<String,Integer> inventory_list = inventory.get_item();
        HashMap<String,Integer> order_list = order.get_order_list();
        for (String key_inventory: inventory_list.keySet()){
            for (String key_order: order_list.keySet()){
                if(Objects.equals(key_inventory, key_order)){
                    if (inventory_list.get(key_inventory) > order_list.get(key_order)){
                        inventory_list.computeIfPresent(key_inventory,(key, value) -> value-order_list.get(key_order));
                    }
                }
                ItemReadWriter.writeItems(key_inventory,inventory_list.get(key_inventory));
            }
        }
        return inventory_list;
    }
}

