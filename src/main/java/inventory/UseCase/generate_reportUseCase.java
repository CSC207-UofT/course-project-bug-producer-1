package inventory.UseCase;

import inventory.Inventory;
import item.Item;

import java.io.IOException;
import java.util.HashMap;

/**
 *this class is an usecase class of the inventory, it is used to give report of the item in the inventory
 * in this case other class can always see what in the inventory
 * @author kurisu
 */
public class generate_reportUseCase {
    /**
     * this method is used to generate the report of the item list in the inventory
     * @param inventory get the item in the inventory
     * @return return a long string of like a report include the item in the inventory at the time.
     */
    public static HashMap<String,Integer> generate_report(Inventory inventory){
        return inventory.get_item();
    }
}
