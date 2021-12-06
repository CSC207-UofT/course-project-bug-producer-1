package main.java.order;

import main.java.inventory.Inventory;
import main.java.item.Item;
import main.java.inventory.Inventory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import main.java.order.OrderGenerateUseCase;

/**
 * This class is a controller class to create order and sent orders to inventory to handle.
 * @author Hao li
 */
public class OrderController {

    /**
     * this method is used to create an order for customer.
     */
    public static Order generate_order_customer(HashMap<Item, Integer> item_list){
        return OrderGenerateUseCase.Generate_order_customer(item_list);
    }
    /**
     * this method is used to create an order for customer.
     */
    public static Order generate_order_stock(HashMap<Item, Integer> item_list){
        return  OrderGenerateUseCase.Generate_order_in_stock(item_list);
    }

    public static String getOrderID_con(Order order){
        return OrderGenerateUseCase.getOrderID(order);
    }

    public static String getOrderDate_con(Order order){
        return OrderGenerateUseCase.getOrderDate(order);
    }

    public static String get_total_item_con(Order order){
        return OrderGenerateUseCase.get_total_item(order);
    }

    public static Order generate_order_from_GUI(String item, String userID) throws IOException {
        return OrderGenerateUseCase.Generate_order_in_GUI(item,userID);
    }
}
