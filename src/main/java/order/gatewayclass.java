package order;

import order.usecase.file_writer;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A Gateway controls the interaction between database and use cases (log in and register).
 */
public class gatewayclass {
    /**
     *
     * @param order An order object.
     * @param userID username of userID.
     * @param item  GUI input consist of order detail.
     * @param status String represents status.
     * @throws IOException check if error throws.
     */
    public static void write_Order_history(Order order, String userID, String item, String status) throws IOException{
        file_writer.write_Order_history(order,userID,item,status);
    }

    /**
     *
     * @return return an Arraylist of String of array, each element is an order detail.
     */
    public static ArrayList<String[]> readOrder() {
        return file_writer.readOrder();
    }
    /**
     *
     * @return return an Arraylist of String of array for a single user, each element is an order detail.
     */
    public static ArrayList<String[]> readOrder(String userID) {
        return file_writer.readOrder(userID);
    }
}
