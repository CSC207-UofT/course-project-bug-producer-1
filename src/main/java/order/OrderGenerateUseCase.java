package order;

import item.*;

import java.io.IOException;
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
    public static Order Generate_order_in_GUI(String item, String username) throws IOException {
        item = item.substring(1, item.length() -1);
        HashMap<Item, Integer> order_component = new HashMap<>();
        String[] str_ary = item.split(",");
        for(String str: str_ary){
            String[] temp = str.split(" \\| ");
            order_component.put(new Item(temp[0],Integer.parseInt(temp[1])),Integer.parseInt(temp[1]));
        }
        Order rel = Generate_order_customer(order_component);
        rel.update_customer(username);
        file_writer.write_Order_history(rel,username,item);
        return rel;
    }
    /**
     * this method is used to get the id of an order.
     */
    public static String getOrderID(Order order){
        return order.get_id();
    }

    /**
     * this method is used to get the date of an order.
     */
    public static String getOrderDate(Order order){
        return order.getOrderDate();
    }

    /**
     * this method is used to get the total number of item(s) of an order.
     */
    public static String get_total_item(Order order){
        return order.get_total_item();
    }

    public static Order find_order(String orderID){
        String tempo = file_writer.get_order_specific(orderID);
        String[] tempo_ary = tempo.split(" \\.");
        HashMap<Item, Integer> order_component = new HashMap<>();
        for(String str: tempo_ary){
            String[] temp = str.split(" \\| ");
            order_component.put(new Item(temp[0],Integer.parseInt(temp[1])),Integer.parseInt(temp[1]));
        }
        return Generate_order_customer(order_component);
    }
}
