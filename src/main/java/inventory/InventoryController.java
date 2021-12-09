package inventory;

import inventory.useCase.*;
import order.Order;

import java.io.IOException;
import java.util.HashMap;

/**
 *this class is a controller class of the inventory used in the project
 *it controls the inventory stock in, stock out and generate report
 *this class accept the input of the users and control the action of the program according to the content of the input.
 * @author kurisu
 */
@SuppressWarnings("unused")
public class InventoryController {
    public Order order;
    /**
     * this method generates a hashmap of item when some item stock in
     *
     * @param order     get the order list and the number of the item need stock in
     */
    public static void generate_stock_in(Order order) throws IOException {
        InventoryStockinUseCase.stock_in(order);
    }

    /**
     * this method generates a hashmap of item when some item stock out
     * @param order get the order list and the number of the item need stock out
     */
    public static void generate_stock_out(Order order) throws IOException {
        InventoryStockoutUseCase.stock_out(order);
    }

    /**
     * this method generates a report of item in the inventory after some item stock out or in
     * @return return a hashmap of inventory item
     */
    public static HashMap<String,Integer> generate_report(){
        return generate_reportUseCase.generate_report();
    }

}
