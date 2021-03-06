package inventory.useCase;

import inventory.Inventory;

import java.util.HashMap;

/**
 *this class is an usecase class of the inventory, it is used to give report of the item in the inventory
 * in this case other class can always see what in the inventory
 * @author kurisu
 */
public class generate_reportUseCase {
    /**
     * this method is used to generate the report of the item list in the inventory
     * @return return a hashmap of the item in the inventory
     */
    public static HashMap<String,Integer> generate_report(){
        Inventory inventory = read_inventoryUseCase.read_inventory();
        return inventory.get_item();
    }
}
