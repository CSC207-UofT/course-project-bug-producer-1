package main.java.order;

import main.java.inventory.Inventory;
import main.java.item.Item;
import main.java.inventory.Inventory;

import java.util.Date;
import java.util.HashMap;
import main.java.order.OrderGenerateUseCase;

/**
 * This class is a controller class to create order and sent orders to inventory to handle.
 * @author Hao li
 */
public class OrderController {

//    public boolean review_order(Order order, Inventory inventory){
//        HashMap<Item, Integer> inter = order.get_item_list();
//        HashMap<Item, Integer> invenlst = inventory.get_item_list();
//        for(Item key: inter.keySet()){
//            if(inter.get(key) > invenlst.get(key)){
//                order.up_date_status("refused");
//                return false;
//            }
//        }
//        order.up_date_status("processing");
//        return true;
//        return true;
//    }
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
}
