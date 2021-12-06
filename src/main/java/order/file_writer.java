package main.java.order;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class file_writer{
    /**
     * Writes the order details to file at filePath.
     *
     * @param order an order object that represents an order to be recorded.
     */

    public static void write_Order_history(Order order, String userID) throws IOException {
        try {
            File csv = new File("order_database.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            String values = userID+ "," +order.get_id()+ "," +order.getOrderDate()+ "," +order.get_total_item();
            bw.write(values);
            bw.newLine();
            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Store the users to file at filePath.
     * @return A list of user
     */
    public static ArrayList<String[]> readOrder() throws IOException {
        File csv = new File("order_database.csv ");
        ArrayList<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                result.add(values);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<String[]> readOrder(String userID) throws IOException {
        File csv = new File("order_database.csv ");
        ArrayList<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                if(Objects.equals(values[0], userID)){
                    result.add(values);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
