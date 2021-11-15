package main.java.order;

import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;


/**
 * This class is a use case class of an order to create order.
 * @author Hao li
 */
public class OrderGenerateUseCase {

    /**
     * this method is used to create an order for customer.
     */
    public static Order Generate_order_customer(Date date, HashMap<Item, Integer> item_list) {
        return new Order(date, item_list);
    }

    /**
     * this method is used to create an order for inventory to supply items.
     */
    public static Order Generate_order_in_stock(Date date, HashMap<Item, Integer> item_list){
        return new Order(date, item_list,"Order_in");
    }
}