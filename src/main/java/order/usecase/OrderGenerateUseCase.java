package order.usecase;

import gui.Constant;
import item.*;
import order.Order;

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
     * this method uses input from GUI to produce an order
     * @param item string of input that requires certain items.
     * @return create an order for customer
     */
    public static Order Generate_order_in_GUI(String item, String username) throws IOException {
        Order rel = Generate_order_customer(helper_method_gui(item));
        rel.update_customer(username);
        file_writer.write_Order_history(rel,username,item, "out");
        return rel;
    }
    /**
     * this method uses input from GUI to produce an order for admin to increase order.
     * @param item string of input that requires certain items.
     * @return create an order for customer
     */
    public static Order Generate_order_in_GUI_admin(String item) throws IOException {
        String username = Constant.getCurrUsername();
        Order rel = Generate_order_customer(helper_method_gui(item));
        rel.update_customer(username);
        file_writer.write_Order_history(rel,username,item, "in");
        return rel;
    }
    /**
     * this method uses input from GUI to find an order
     * @param orderID string of input that requires certain items.
     * @return create an order for customer
     */
    public static Order find_order(String orderID){
        String tempo = file_writer.get_order_specific(orderID);
        String[] tempo_ary = tempo.split(" \\.");
        HashMap<Item, Integer> order_component = new HashMap<>();
        for(String str: tempo_ary){
            String[] temp = str.split(" \\| ");
            order_component.put(new Item(temp[0],Integer.parseInt(temp[1])), Integer.parseInt(temp[1]));
        }
        return Generate_order_customer(order_component);
    }

    /**
     * A helper method used to produce a hashmap object given a string.
     */
    private static HashMap<Item, Integer> helper_method_gui(String item){
        item = item.substring(1, item.length() -1);
        HashMap<Item, Integer> order_component = new HashMap<>();
        String[] str_ary = item.split(" \\.");
        for(String str: str_ary){
            String[] temp = str.split(" \\| ");
            order_component.put(new Item(temp[0],Integer.parseInt(temp[1])),Integer.parseInt(temp[1]));
        }
        return order_component;
    }
}
