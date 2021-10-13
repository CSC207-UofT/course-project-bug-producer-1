package main.java.inventory;
import main.java.inventory.Inventory;
import java.util.HashMap;

public class InventoryController {
    public HashMap<String, Integer> item_list = new HashMap<String, Integer>();

    public show_item_list(HashMap<String, Integer> item_list){
        return "item_list:" + item_list.KeySet();
    }

    /*for (String item: item_list.KeySet()){
        return item + ","
    }*/

    public stock_in_instruct(){

    }

    public stock_out_instruct(){

    }
}
