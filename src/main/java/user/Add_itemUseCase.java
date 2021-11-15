package main.java.user;

import main.java.inventory.Inventory;

import main.java.item.Item;

import java.util.HashMap;

public class Add_itemUseCase {
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
