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
    public static Order generate_order_customer(Date date, HashMap<Item, Integer> item_list){
        return OrderGenerateUseCase.Generate_order_customer(date, item_list);
    }
    /**
     * this method is used to create an order for customer.
     */
    public static Order generate_order_stock(Date date, HashMap<Item, Integer> item_list){
        return  OrderGenerateUseCase.Generate_order_in_stock(date, item_list);
    }
}
