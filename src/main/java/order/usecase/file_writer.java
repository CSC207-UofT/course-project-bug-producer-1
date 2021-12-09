package order.usecase;

import order.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is a use case class of order for storing order information and extracting information.
 * @author Hao li
 */


public class file_writer{
    /**
     * Writes the order details to file at filePath.
     *
     * @param order an order object that represents an order to be recorded.
     */

    public static void write_Order_history(Order order, String userID, String item, String status) throws IOException {
        try {
            File csv = new File("order_database.csv");
            if (!csv.exists()) {
                boolean newFile = csv.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));

            String values = userID+ "," +order.get_id()+ "," +order.getOrderDate()+ "," +order.get_total_item() +
                    "," + item.substring(1, item.length() - 1) + "," + status;

            bw.write(values);
            bw.newLine();
            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method produces order information for certain user.
     * @return A list of lists with each list of 4 element inside outer list is order has username,order number
     * order_date and number of total item.
     */
    public static ArrayList<String[]> readOrder(){
        File csv = new File("order_database.csv");
        if (!csv.exists()) {
            try {
                boolean newFile = csv.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                result.add(values);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * this method produces order information for all orders having been created.
     * @return A list of lists with each list of 4 element inside outer list is order has username,order number
     * order_date and number of total item.
     */
    public static ArrayList<String[]> readOrder(String userID){
        File csv = new File("order_database.csv");
        ArrayList<String[]> result = new ArrayList<>();
        if (!csv.exists()) {
            try {
                boolean newFile = csv.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            if (!csv.exists()) {
                boolean newFile = csv.createNewFile();
            }
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                if(Objects.equals(values[0], userID)){
                    result.add(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * this method produces order information for all orders having been created.
     * @return A list of lists with each list of 4 element inside outer list is order has username,order number
     * order_date and number of total item.
     */
    public static String get_order_specific(String orderID){
        File csv = new File("order_database.csv");
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                if (Objects.equals(values[1], orderID)) {
                    result.append(values[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
