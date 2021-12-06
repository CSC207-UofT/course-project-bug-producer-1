package order;

import item.Item;

import java.io.IOException;
import java.util.HashMap;
import order.OrderGenerateUseCase;

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

    /**
     * this method is used to get the id of an order.
     */
    public static String getOrderID_con(Order order){
        return OrderGenerateUseCase.getOrderID(order);
    }

    /**
     * this method is used to get the date of an order.
     */
    public static String getOrderDate_con(Order order){
        return OrderGenerateUseCase.getOrderDate(order);
    }

    /**
     * this method is used to get the total number of item(s) of an order.
     */
    public static String get_total_item_con(Order order){
        return OrderGenerateUseCase.get_total_item(order);
    }
    /**
     * this method uses input from GUI to produce an order
     * @param item string of input that requires certain items.
     * @return create an order for customer
     */
    public static Order generate_order_from_GUI(String item, String userID) throws IOException {
        return OrderGenerateUseCase.Generate_order_in_GUI(item,userID);
    }


}
