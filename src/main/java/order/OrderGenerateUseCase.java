package main.java.order;

import main.java.item.*;

import java.util.*;


/**
 * This class is a use case class of an order to create order.
 * @author Hao li
 */
public class OrderGenerateUseCase {

    /**
     * this method is used to create an order for customer.
     */
    public static Order Generate_order_customer(HashMap<Item, Integer> item_list) {
        return new Order(item_list);
    }

    /**
     * this method is used to create an order for inventory to supply items.
     */
    public static Order Generate_order_in_stock(HashMap<Item, Integer> item_list){
        return new Order(item_list,"Order_in");
    }

    /**
     * this method uses input from GUI to produce an order
     * @param item string of input that requires certain items.
     * @return create an order for customer
     */

    public static Order Generate_order_in_GUI(String item, String userID){
        item = item.substring(0, item.length() -1);

        HashMap<Item, Integer> order_component = new HashMap<>();
        String[] str_ary = item.split(", ");
        for(String str: str_ary){
            String[] temp = str.split(" \\| ");
            order_component.put(new Item(temp[0],Integer.parseInt(temp[1])),Integer.parseInt(temp[1]));
        }
        Order rel = Generate_order_customer(order_component);
        rel.update_customer(userID);
        return rel;
    }

    public static String getOrderID(Order order){
        return order.get_id();
    }

    public static String getOrderDate(Order order){
        return order.getOrderDate();
    }

    public static String get_total_item(Order order){
        return order.get_total_item();
    }
}
