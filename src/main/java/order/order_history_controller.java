package main.java.order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is a gateway class to extract information of orders from database.
 * @author Hao li
 */

public class order_history_controller{

    /**
     * this method produces order information for certain user.
     * @return A list of lists with each list of 4 element inside outer list is order has username,order number
     * order_date and number of total item.
     */
    public static ArrayList<String[]> get_order_history_for_user(String username) throws IOException {
        return file_writer.readOrder(username);
    }
    /**
     * this method produces order information for all orders having been created.
     * @return A list of lists with each list of 4 element inside outer list is order has username,order number
     * order_date and number of total item.
     */
    public static ArrayList<String[]> get_order_history_all() throws IOException {
        return file_writer.readOrder();
    }

    public static Order find_order(String input) throws IOException {
        return OrderGenerateUseCase.find_order(input);

    }
}