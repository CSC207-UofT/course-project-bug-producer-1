package main.java.order;
import main.java.item.Item;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * This class is an entity class of the Representation of an order.
 * @author Hao li
 */

public class Order {

    private final Date date;
    private final HashMap<Item, Integer> item_list;
    private final String OrderID;
    private final String status;

    /**
     * This method is the constructor of the order, which instantiates a new Order object.
     * It is used to create an order of supplement.
     * @param item_list The list of items bought by the customer.
     * @param date The date when the order placed.
     * @param status The status of the order.
     */

    public Order(Date date,HashMap<Item, Integer> item_list,String status){
        this.date = date;
        this.item_list = item_list;
        this.OrderID = generate_order_number();
        this.status = status;
    }

    /**
     * This method is the constructor of the order, which instantiates a new Order object. except it is overlaoding
     * version of thr original constructor used to creat an order for output.
     *
     * @param item_list The list of items bought by the customer.
     * @param date The date when the order placed.
     */
    public Order(Date date,HashMap<Item, Integer> item_list){
        this.date = date;
        this.item_list = item_list;
        this.OrderID = generate_order_number();
        this.status = "Order_out";
    }

    /**
     * This method is used to get the date of order.
     */
    public Date get_date(){
        return this.date;
    }

    /**
     * This method is used to get the item list of the order.
     */
    public HashMap<Item, Integer> get_item_list(){
        return this.item_list;
    }

    /**
     * This method is used to get the id of the order.
     */
    public String get_id(){
        return this.OrderID;
    }

    /**
     * This method is used to get the status of the order to distinguish whether order is for supplement or output.
     */
    public String get_status(){
        return this.status;
    }

    /**
     * This method is used to generate a unique id of the order to track order.
     */
    private String generate_order_number(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 2; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
