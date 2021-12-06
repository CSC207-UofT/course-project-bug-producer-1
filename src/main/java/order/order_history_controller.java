package main.java.order;

import java.io.IOException;
import java.util.ArrayList;

public class order_history_controller{

    public ArrayList<String[]> get_order_history_for_user(String username) throws IOException {
        return file_writer.readOrder(username);
    }

    public ArrayList<String[]> get_order_history_all() throws IOException {
        return file_writer.readOrder();
    }
}