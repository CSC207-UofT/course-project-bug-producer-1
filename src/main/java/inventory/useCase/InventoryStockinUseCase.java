package inventory.useCase;

import inventory.Inventory;
import item.Gateway;
import order.Order;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**this class is an usecase class of the inventory
 * this class is uesed for stock in the item into the inventory
 * @author kurisu
 */
public class InventoryStockinUseCase {
    /**
     * this method show how to stock in the item into the inventory
     * @param order get the order list and the number of the item need stock in
     */
    public static void stock_in(Order order) throws IOException {
        Inventory inventory = read_inventoryUseCase.read_inventory();
        HashMap<String,Integer> inventory_list = inventory.get_item();
        HashMap<String,Integer> order_list = order.get_order_list();
        if (inventory_list.isEmpty()){
            for (String key_order: order_list.keySet()){
                inventory_list.computeIfAbsent(key_order, key -> order_list.get(key_order));
                Gateway.writeItems(key_order,order_list.get(key_order));
            }
        }
        else {
            for (String key_inventory : inventory_list.keySet()) {
                for (String key_order : order_list.keySet()) {
                    if (Objects.equals(key_inventory, key_order)) {
                        inventory_list.computeIfPresent(key_inventory, (key, value) -> value + order_list.get(key_order));
                    }
                    else {
                        inventory_list.computeIfAbsent(key_order, key -> order_list.get(key_order));
                    }
                    Gateway.writeItems(key_inventory,inventory_list.get(key_inventory));
                }
            }
        }
    }
}

