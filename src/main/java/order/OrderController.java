package order;
import inventory.InventoryController;
import order.usecase.OrderGenerateUseCase;
import java.io.IOException;


/**
 * This class is a controller class to create order and sent orders to inventory to handle.
 * @author Hao li
 */
public class OrderController {

    /**
     * this method uses input from GUI to produce an order
     * @param item string of input that requires certain items.
     */
    public static void generate_order_from_GUI(String item, String userID) throws IOException {
        Order order = OrderGenerateUseCase.Generate_order_in_GUI(item,userID);
        InventoryController.generate_stock_out(order);
    }
    /**
     * this method uses input from GUI to produce an order for admin.
     * @param item string of input that requires certain items.
     */
    public static void generate_order_from_GUI_admin(String item) throws IOException {
        Order order = OrderGenerateUseCase.Generate_order_in_GUI_admin(item);
        InventoryController.generate_stock_in(order);
    }
}
