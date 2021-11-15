package main.java.inventory;
import main.java.item.Item;

import java.util.HashMap;

/**
 *this class is a controller class of the inventory used in the project
 *it controls the inventory stock in, stock out and generate report
 *this class accept the input of the users and control the action of the program according to the content of the input.
 * @author kurisu
 */
public class InventoryController {
    public HashMap<Item, Integer> item_list;
    public int num_in;
    public int num_out;
    public Item key_item;

    /**
     * this method is an initiator of the class.
     * @param item_list a hash map that contains the item and the number of each item
     * @param num_in an int that show how much the item stock in
     * @param num_out an int that show how much the item stock out
     * @param key_item an item param that show the key in the item hashmap
     */

    public InventoryController(HashMap<Item, Integer> item_list, int num_in, int num_out, Item key_item){
        this.item_list = item_list;
        this.num_in = num_in;
        this.num_out = num_out;
        this.key_item = key_item;
    }

    /**
     * this method generates a hashmap of item when some item stock in
     * @param item_list a hash map that contains the item and the number of each item
     * @param num_in an int that show how much the item stock in
     * @param key_item an item param that show the key in the item hashmap
     * @return return a new hashmap of the inventory item after stock in
     */
    public HashMap<Item, Integer> generate_stock_in(HashMap<Item, Integer> item_list, int num_in, Item key_item){
        return main.java.inventory.InventoryStockinUseCase.stock_in(this.item_list, this.num_in, this.key_item);
    }

    /**
     * this method generates a hashmap of item when some item stock out
     * @param item_list a hash map that contains the item and the number of each item
     * @param num_out an int that show how much the item stock out
     * @param key_item an item param that show the key in the item hashmap
     * @return return a new hashmap of the inventory item after stock out
     */
    public HashMap<Item, Integer> generate_stock_out(HashMap<Item, Integer> item_list, int num_out, Item key_item){
        return main.java.inventory.InventoryStockoutUseCase.stock_out(this.item_list, this.num_out, this.key_item);
    }

    /**
     * this method generates a report of the newest inventory item
     * @param item_list a hash map that contains the item and the number of each item
     * @return return a long string report of the inventory item
     */
//    public String generate_report(HashMap<Item, Integer> item_list){
//        return generate_reportUseCase.generate_report(this.item_list);
//    }
}
