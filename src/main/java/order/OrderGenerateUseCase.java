package main.java.order;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;

public class OrderGenerateUseCase {

    public Order Generate_order(Date date, HashMap<Item, Integer> item_list, String itemID, int customerID) {
        return new Order(date, item_list, itemID, customerID);
    }
}