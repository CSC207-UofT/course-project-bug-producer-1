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
    private String userID;
    /**
     * This method is the constructor of the order, which instantiates a new Order object.
     * It is used to create an order of supplement.
     * @param item_list The list of items bought by the customer.
     * @param status The status of the order.
     */

    public Order(HashMap<Item, Integer> item_list,String status){
        this.date = new Date();
        this.item_list = item_list;
        this.OrderID = generate_order_number();
        this.status = status;
    }

    /**
     * This method is the constructor of the order, which instantiates a new Order object. except it is overlaoding
     * version of thr original constructor used to creat an order for output.
     *
     * @param item_list The list of items bought by the customer.
     */
    public Order(HashMap<Item, Integer> item_list){
        this.date = new Date();
        this.item_list = item_list;
        this.OrderID = generate_order_number();
        this.status = "Order_out";
        this.userID = "";
    }
    /**
     * This method is used to get the date of string version of order.
     */
    public String getOrderDate(){
        return this.date.toString();
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
     * This method is used to get customer name for this order.
     */
    public void update_customer(String input){
        this.userID = input;
    }
    /**
     * This method is used to get customer name for this order.
     */
    public String get_username(){
        return this.userID;
    }
    /**
     *
     * this method is used to return the total number of the order.
     */
    public String get_total_item() {
        int i = 0;
        for (int temp : item_list.values()) {
            i += temp;
        }
        return String.valueOf(i);
    }
    /**
     * This method is used to generate a unique id of the order to track order.
     */
    public static String generate_order_number(){
        Random random = new Random();
        StringBuilder result= new StringBuilder();
        for(int i=0;i<8;i++){
            result.append(random.nextInt(9) + 1);
        }
        return result.toString();
    }
}
