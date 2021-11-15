package main.java.user;

import main.java.inventory.Inventory;

import java.util.HashMap;

public class Add_itemUseCase {
    public HashMap<String, Integer> add_item(HashMap<String, Integer> user_input_wish_list){
        HashMap<String, Integer> processed_wish_list = new HashMap<>();
        user_input_wish_list.forEach((key, value) -> {
            if(value <= Inventory.get_item_list().get(key)){
                processed_wish_list.put(key, value);
            }
        });
        return processed_wish_list;
    }
}
