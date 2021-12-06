package main.java.inventory;
import main.java.item.Item;
import main.java.order.Order;

import java.io.IOException;
import java.util.HashMap;

/**
 *this class is a controller class of the inventory used in the project
 *it controls the inventory stock in, stock out and generate report
 *this class accept the input of the users and control the action of the program according to the content of the input.
 * @author kurisu
 */
public class InventoryController {
    public Order order;
    /**
     * this method generates a hashmap of item when some item stock in
     *
     * @param order     get the order list and the number of the item need stock in
     * @param inventory get the item in the inventory
     * @return return a new hashmap of the inventory item after stock in
     */
    public HashMap<String, Integer> generate_stock_in(Order order, Inventory inventory) throws IOException {
        return main.java.inventory.UseCase.InventoryStockinUseCase.stock_in(order, inventory);
    }

    /**
     * this method generates a hashmap of item when some item stock out
     * @param order get the order list and the number of the item need stock out
     * @param inventory get the item in the inventory
     * @return return a new hashmap of the inventory item after stock out
     */
    public HashMap<String, Integer> generate_stock_out(Order order, Inventory inventory) throws IOException {
        return main.java.inventory.UseCase.InventoryStockoutUseCase.stock_out(order, inventory);
    }
}
