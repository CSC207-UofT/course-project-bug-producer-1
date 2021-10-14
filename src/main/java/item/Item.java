package main.java.item;
import main.java.item.Order;
import main.java.item.Inventory;

import java.util.HashMap;

public class Item {
    private String name;
    private int ID;
    private int capacity;
    private int quantity;
    public Item(String name, int ID, int capacity, int quantity){
        this.name = name;
        this.ID = ID;
        this.capacity = capacity;
        this.quantity = quantity;
    }


    public void update_quantity_in(int num){
        this.quantity = this.quantity - num;
    }

    public void update_quantity_out(int num){
        this.quantity = this.quantity - num;
    }


}
