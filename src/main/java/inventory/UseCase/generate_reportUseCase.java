package main.java.inventory.UseCase;

import main.java.item.Item;

import java.util.HashMap;

/**
 *this class is an usecase class of the inventory, it is used to give report of the item in the inventory
 * in this case other class can always see what in the inventory
 * @author kurisu
 */
public class generate_reportUseCase {
    /**
     * this method is used to generate the report of the item list in the inventory
     * @param item_list it shows the item in the inventory
     * @return return a long string of like a report include the item in the inventory at the time.
     */
    public static String generate_report(HashMap<Item, Integer> item_list){
        return "report:" + item_list.entrySet();
    }
}
