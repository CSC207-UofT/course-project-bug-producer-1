package main.java.user.UseCase;

import main.java.inventory.Inventory;

import main.java.item.Item;

import java.util.HashMap;

/**
 * This is a class that add items to the wish_list of the customer.
 */

public class Add_itemUseCase {

    /**
     * This is a method that add items to the wish_list of the customer.
     * @param user_input_wish_list A wish_list typed in by the customer in the UI.
     * @return processed_wish_list A HashMap that contains the items that have enough storage in inventory.
     */
    public HashMap<Item, Integer> add_item(HashMap<Item, Integer> user_input_wish_list){
        HashMap<Item, Integer> processed_wish_list = new HashMap<>();
        user_input_wish_list.forEach((key, value) -> {
            if(value <= Inventory.get_item_list().get(key)){
                processed_wish_list.put(key, value);
            }
        });
        return processed_wish_list;
    }
}
