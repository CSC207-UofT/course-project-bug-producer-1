package main.java.order;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;

public class OrderGenerateUseCase {

    public Order Generate_order(Date date, String item_name, String customerID) {
        return new Order(date, item_name, customerID);
    }
}